package com.metalsphere.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import com.metalsphere.Controller;
import com.metalsphere.Game;
import com.metalsphere.core.CoreObject;
import com.metalsphere.entity.Player;
import com.metalsphere.gfx.Texture;
import com.metalsphere.libs.Identities;



public class Block extends CoreObject{

	private static ArrayList<CoreObject> ALL=Controller.getObjects();
	private Block block;
	private Player player;
	private BufferedImage image;
	
	public Block(int x,int y,int id,Texture tex,BufferedImage image) {
		super(x,y,id,tex);
		this.image=image;
		
	}

	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		checkCollision();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		
	}
	private void checkCollision(){
		for(CoreObject obj:ALL){
			if(obj.getId()==Identities.PLAYER)player=(Player)obj;
		}
		for(CoreObject obj : ALL){
			if(obj.getId()==Identities.BLOCK_STONE){
				block = (Block)obj;

				if(block.getLeftBounds().intersects(player.getRightBounds())){
					Player.setRightCollision(true);
					player.setX_dis(0);
					for(CoreObject obj2:ALL){
						if(obj2.getId()==Identities.BLOCK_STONE)obj2.setX(obj2.getX()+1);
					}
				}else Player.setLeftCollision(false);;
				if(block.getRightBounds().intersects(player.getLeftBounds())){
					Player.setRightCollision(true);
					player.setX_dis(0);
					for(CoreObject obj2:ALL){
						if(obj2.getId()==Identities.BLOCK_STONE)obj2.setX(obj2.getX()-1);
					}
				}else Player.setRightCollision(false);
			}
		}
		
	}
	

}
