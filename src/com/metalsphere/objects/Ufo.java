package com.metalsphere.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.metalsphere.Controller;
import com.metalsphere.core.CoreObject;
import com.metalsphere.entity.Player;
import com.metalsphere.gfx.Texture;


public class Ufo extends CoreObject{
	private static ArrayList<CoreObject> ALL=Controller.getObjects();
	private Ufo ufo;
	private Player player;
	private BufferedImage image;
	

	public Ufo(int x, int y, int id, Texture tex,BufferedImage image) {
		super(x, y, id, tex);
		this.image = image;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,x,y,null);
		
	}

}
