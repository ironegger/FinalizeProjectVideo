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



public class Enemy extends CoreObject{

	private static ArrayList<CoreObject> ALL=Controller.getObjects();
	private Enemy enemy;
	private Player player;
	private BufferedImage image;
	private boolean taken;
	public Enemy(int x, int y, int id, Texture tex,BufferedImage image) {
		super(x, y, id, tex);
		this.image = image;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		checkCollision();
		
	}
	public void checkCollision(){
		player = Game.getInstance().getGenerator().getThisPlayer();
		for(CoreObject obj : ALL){
			if(obj.getId()==Identities.aliean_1){
				enemy = (Enemy)obj;
				
				if(enemy.getLeftBounds().intersects(player.getRightBounds())){
					player.setAlive(false);
				}else Player.setLeftCollision(false);
				if(enemy.getRightBounds().intersects(player.getLeftBounds())){
					player.setAlive(false);
				}else Player.setRightCollision(false);
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		
	}

}
