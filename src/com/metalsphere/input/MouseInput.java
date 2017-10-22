package com.metalsphere.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.metalsphere.Game;
import com.metalsphere.enums.GameState;
import com.metalsphere.libs.Audio;
import com.metalsphere.screens.Intermediate;
import com.metalsphere.screens.Menu;
import com.metalsphere.screens.Option;
import com.metalsphere.screens.Over;
import com.metalsphere.screens.Pause;
import com.metalsphere.screens.Victory;
import com.metalsphere.utils.AudioPlayer;



public class MouseInput extends MouseAdapter {
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	
	private Menu menu=Game.getInstance().getMenu();
	private Over over = Game.getInstance().getOver();
	private Pause pause = Game.getInstance().getPause();
	private Victory victory = Game.getInstance().getVictory();
	private Intermediate intermediate = Game.getInstance().getIntermediate();
	public static boolean firstContact=true;
	/**
	 * true if a mouse button is pressed
	 */
	public static boolean pressed = false;

	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();// used to check what button was clicked
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);//

		if (mouse == MouseEvent.BUTTON1) {
			switch (Game.state) {
			case GAME:

				break;
			case MENU:
				// buttun Play -> Play screen and start game
				if (rect.intersects(menu.play)) {
					AudioPlayer.playSoundEffect(Audio.wohoo);
					Game.getInstance().getGenerator().init();
					Game.state = GameState.GAME;
				} else if (rect.intersects(menu.quit)) {
				}
				// button option -> enter option screen
				else if (rect.intersects(menu.options)) {
					AudioPlayer.playSoundEffect(Audio.SOUND_menu_click);
					Game.state=GameState.OPTIONS;
				}
				break;
			case OPTIONS:
			// button help -> help screen
			if (rect.intersects(Option.help)) {
				Game.state=GameState.HELP;
	                } else if (rect.intersects(Option.back)) {
	                //button back -> go back to menu
				Game.state = GameState.MENU;
	                } else if (rect.intersects(Option.mute)) {
			// button mute -> run an vbs to mute
	                    try {
	                        Runtime.getRuntime().exec("cmd /c wscript \"./lib/Mute.vbs\"");
	                    } catch (Exception exc) {
	                        exc.printStackTrace();
	                    }
	                } else if (rect.intersects(Option.volup)) {
				//button volume up 
	                    try {
	                        Runtime.getRuntime().exec("cmd /c wscript \"./lib/volumeUp.vbs\"");
	                    } catch (Exception exc) {
	                        exc.printStackTrace();
	                    }
	                } else if (rect.intersects(Option.voldown)) {
				//button volume down
	                    try {
	                        Runtime.getRuntime().exec("cmd /c wscript \"./lib/volumeDown.vbs\"");
	                    } catch (Exception exc) {
	                        exc.printStackTrace();
	                    }
	                }
				break;
			case PAUSE:
					//button quit: quit the game 
				if(rect.intersects(pause.quit)){
					Game.getInstance().getMenu().setMusicPlay(false);
					Game.state = GameState.MENU;
				}
					// button contine: continue == esc (in KeyInput)
				else if(rect.intersects(pause.goon)){
					Game.state = GameState.GAME;
					Game.getInstance().getGenerator().getThisPlayer().setY(Game.getInstance().getGenerator().getThisPlayer().getCachePos());
				}
				break;
			case GAMEOVER:
				Game.getInstance().getOver().setMusicPlay(false);
				Game.getInstance().getMenu().setMusicPlay(false);
					// quit the game
				if(rect.intersects(over.quit)){System.exit(1);}
					// back to menu
				else if(rect.intersects(over.mainmenu)){
					Game.getInstance().getMenu().setMusicPlay(false);
					Game.state = GameState.MENU;
				}
					// playagain
				else if(rect.intersects(over.playagain)){
					Game.getInstance().getGenerator().init();					
					Game.state = GameState.GAME;
				}
				break;
			case VICTORY:
				Game.getInstance().getOver().setMusicPlay(false);
				Game.getInstance().getMenu().setMusicPlay(false);
					// qui the game
				if(rect.intersects(victory.quit))System.exit(1);
					// go back to menu
				else if(rect.intersects(victory.mainmenu)){
					Game.getInstance().getMenu().setMusicPlay(false);
					Game.state = GameState.MENU;
					AudioPlayer.playMusic(Audio.seeyou);
				}
					// playagain
				else if(rect.intersects(victory.playagain)){
					Game.getInstance().getGenerator().init();					
					Game.state = GameState.GAME;
				}
				break;
			case INTERMEDIATE:
					//go to next stage
				if(rect.intersects(intermediate.next)){
					Game.getInstance().state = GameState.GAME;
				}
					//go back to menu
				else if(rect.intersects(intermediate.mainmenu)){
					Game.getInstance().getMenu().setMusicPlay(false);
					Game.state = GameState.MENU;
				}
					// quit the game
				else if(rect.intersects(intermediate.quit)){
					System.exit(0);
				}
				break;
			case HELP:
					//go back to option screen
				if(rect.intersects(intermediate.back)){
					Game.state = GameState.OPTION;
				}	
				break;
			default:
				break;

			}
		}
	}

	public void mousePressed(MouseEvent e) {
		pressed = true;
		// In menu screen, press quit -> exit the game
		if(Game.state==GameState.MENU){
			MOUSE=new Rectangle(e.getX(),e.getY(),1,1);
			if(MOUSE.intersects(menu.quit)){
				AudioPlayer.playSoundEffect(Audio.SOUND_menu_click);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
		if(Game.state==GameState.MENU){
			MOUSE=new Rectangle(e.getX(),e.getY(),1,1);
			if(MOUSE.intersects(menu.quit)){
				System.exit(1);
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		switch(Game.state){
		case GAME:
			break;
		case MENU:
				//button effects as mouse moved
			if((MOUSE.intersects(menu.play)||MOUSE.intersects(menu.options)
					||MOUSE.intersects(menu.quit))&&!AudioPlayer.hasPlayedHover&&firstContact){
							AudioPlayer.playSoundEffect(Audio.hover);
							AudioPlayer.hasPlayedHover=true;
							firstContact=false;}
			else if (!(MOUSE.intersects(menu.play)||MOUSE.intersects(menu.options)
					||MOUSE.intersects(menu.quit))&&AudioPlayer.hasPlayedHover){
				AudioPlayer.hasPlayedHover=false;
				firstContact=true;
				}
			
			
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}

	}

}
