package com.metalsphere.core;

import java.awt.Graphics;
import java.awt.Rectangle;
import com.metalsphere.gfx.Texture;

public abstract class CoreObject {
	protected int x, y, velX,velY;
	protected int id;
	protected Texture tex;
	protected int width=32;
	protected int height=32;
	
	public CoreObject(int x,int y,int id){
		this.x=x;
		this.y=y;
		this.id=id;
		this.tex=tex;
	}

	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getTopBounds(){
		return new Rectangle(x+3,y,width-6,height/2);
	}
	public Rectangle getBottomBounds(){
		return new Rectangle(x+3,y+height/2,width-6,height/2);
	}
	public Rectangle getLeftBounds(){
		return new Rectangle(x-8,y+11,width/2+16,height-22);
	}
	public Rectangle getRightBounds(){
		return new Rectangle(x+width/2,y+11,width/2+8,height-22);
	}
	
	/** 
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param set x coordinate 
	 */
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public long getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}

}
