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
import com.metalsphere.utils.AudioPlayer;



public class Item extends CoreObject{
	private static ArrayList<CoreObject> ALL=Controller.getObjects();
	private Item item;
	private Player player;
	private BufferedImage image;
	private boolean taken;
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public Item(int x, int y, int id, Texture tex,BufferedImage image) {
		super(x, y, id, tex);
		this.image = image;
		taken = false;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		checkCollision();
		
	}

	private void checkCollision() {
		player = Game.getInstance().getGenerator().getThisPlayer();
		
		for(CoreObject obj : ALL){
			if(obj.getId()==Identities.ITEM){
				item = (Item)obj;
				if(!item.isTaken()){
				if(item.getLeftBounds().intersects(player.getRightBounds())){
					AudioPlayer.playSoundEffect("coin");
					Game.getInstance().getGenerator().setScore(50);
					item.setTaken(true);
				}else Player.setLeftCollision(false);
				if(item.getRightBounds().intersects(player.getLeftBounds())){
					Game.getInstance().getGenerator().setScore(50);					
					AudioPlayer.playSoundEffect("coin");
					item.setTaken(true);
				}else Player.setRightCollision(false);
			}
		}
		}
		
	}

	@Override
	public void render(Graphics g) {
		if(!this.taken)
		{g.drawImage(image, x, y, null);}
		
	}

}
