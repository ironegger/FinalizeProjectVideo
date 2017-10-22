package com.metalsphere.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.metalsphere.Game;


public class Renderer {
	//render is a function to draw everything in the game
	
	public Renderer() {
		
	}
	//background is the unchanged image
	public void renderBackground(Graphics g){
		switch(Game.state){
		case GAME:
			
			Game.getInstance().getGenerator().render(g);
			
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTIONS:
			Game.getInstance().getOption().render(g);
			break;
		case PAUSE:
			Game.getInstance().getPause().render(g);
			break;
		case GAMEOVER:
			Game.getInstance().getOver().render(g);
			break;
		case VICTORY:
			Game.getInstance().getVictory().render(g);
			break;
		case INTERMEDIATE:
			Game.getInstance().getIntermediate().render(g);
			break;
		case HELP:
			Game.getInstance().getHelp().render(g);
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE",150,150);
			break;		
		}
		
		
	}
	//foreground means metal ball, blocks, coins...all the moving stuff
	public void renderForeground(Graphics g){
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case GAMEOVER:
			break;
		case VICTORY:
			break;
		default:
			break;
		
		}
	}

}
