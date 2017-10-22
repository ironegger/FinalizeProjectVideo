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

public class Desti extends CoreObject{
	private static ArrayList<CoreObject> ALL=Controller.getObjects();
	private Desti desti;
	private Player player;
	private BufferedImage image;

	public Desti(int x, int y, int id, Texture tex,BufferedImage image) {
		super(x, y, id, tex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		checkCollision();
		
	}

	private void checkCollision() {
		for(CoreObject obj:ALL){
			if(obj.getId()==Identities.PLAYER)player=(Player)obj;
		}
		for(CoreObject obj : ALL){
			if(obj.getId()==Identities.DESTINATION){
				desti = (Desti)obj;
				
				if(desti.getLeftBounds().intersects(player.getRightBounds())){
					
					Game.getInstance().getGenerator().setFinished(true);
					
				}else Player.setLeftCollision(false);;
				if(desti.getRightBounds().intersects(player.getLeftBounds())){
				
					Game.getInstance().getGenerator().setFinished(true);
					
				}else Player.setRightCollision(false);
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
