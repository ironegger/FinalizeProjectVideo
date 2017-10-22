package com.metalsphere.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.metalsphere.Controller;
import com.metalsphere.Game;
import com.metalsphere.core.CoreObject;
import com.metalsphere.entity.Player;
import com.metalsphere.enums.GameState;
import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Identities;
import com.metalsphere.libs.Reference;
import com.metalsphere.utils.AudioPlayer;



public class KeyInput extends KeyAdapter{
	private Player player;
	private CoreObject block;
	
	//Two key pressed
	private boolean[] keyDown = new boolean[2];
	
	public KeyInput(){
		player = Game.getInstance().getGenerator().getThisPlayer();
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			//Space = Jump
			if(key == KeyEvent.VK_SPACE && !player.isJumping())
				{player.setVelY(Reference.velJump);
				player.setJumping(true);
				
				AudioPlayer.playSoundEffect(Audio.jump);}
			//D== move right
			if(key == KeyEvent.VK_D && keyDown[0]==false && !player.isLeftCollision()){
				
				player.setVelX(Game.getInstance().ball_speed_right);
				player.setX_dis(5);
				for(CoreObject obj:Controller.getObjects()){
					
					if(obj.getId()!=Identities.PLAYER){
						block=(CoreObject)obj;
						block.setVelX(Game.getInstance().block_speed);
						}
					
				}
				keyDown[0]=true;				
			}
			//A move left	
			if(key == KeyEvent.VK_A && keyDown[1]==false && !player.isRightCollision())
				{
				keyDown[1]=true;
				player.setVelX(Game.getInstance().ball_speed_left);
				player.setX_dis(Game.getInstance().ball_speed_left);
				
				}
			//ESC pause store current position 
			 if (key == KeyEvent.VK_ESCAPE) {
                 player.setCachePos(player.getY());
                 Game.state = GameState.PAUSE;
             }
             else if (Game.getInstance().block_speed==0)
				 player.setX_dis(0);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
				//ESC continue the game 
			 if (key == KeyEvent.VK_ESCAPE) {
                 Game.state = GameState.GAME;
                 player.setY(player.getCachePos());
                 AudioPlayer.playSoundEffect("pause");
             }
			break;
		default:
			break;
		
		}
	}
	public void  keyReleased(KeyEvent e){
int key=e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			// Two key pressed at the same time
			if(key == KeyEvent.VK_D)
				{keyDown[0]=false;
				player.setX_dis(0);}
			if(key == KeyEvent.VK_A)
				{keyDown[1]=false;
				player.setX_dis(0);}
			if(keyDown[0] && !keyDown[1]){
				for(CoreObject obj:Controller.getObjects()){
					if(obj.getId()!=Identities.PLAYER)block=(CoreObject)obj;
					block.setVelX(Game.getInstance().block_speed);
					
				}
				player.setVelX(Game.getInstance().ball_speed_right);
				
				//player.setVelX(-5);
			}
			if(!keyDown[0] && keyDown[1]){
				for(CoreObject obj:Controller.getObjects()){
					if(obj.getId()!=Identities.PLAYER){
						block=(CoreObject)obj;
						block.setVelX(0);
					}				
				}
				player.setVelX(Game.getInstance().ball_speed_left);
				}
			if(!keyDown[0] && !keyDown[1]){				
				for(CoreObject obj:Controller.getObjects()){
					if(obj.getId()!=Identities.PLAYER){
						block=(CoreObject)obj;
						block.setVelX(0);						
					}
					
				}
				player.setVelX(0);
			}
			break;
		case MENU:
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
