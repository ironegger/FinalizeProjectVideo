package com.metalsphere.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.metalsphere.Controller;
import com.metalsphere.core.CoreObject;
import com.metalsphere.gfx.Texture;
import com.metalsphere.libs.Identities;
import com.metalsphere.libs.Reference;
import com.metalsphere.objects.Block;



public class Player extends CoreObject{
	
	private static ArrayList<CoreObject> ALL =Controller.getObjects();
	private double gravity =Reference.ST1_GRAVITY;
	private Block block;
	private boolean falling = true;
	private static boolean jumping = false;
	private static boolean leftCollision=false;
	
	private static boolean rightCollision=false;
	private boolean isAlive;
	private int x_pos;
	private int x_dis;
	private int cachePos;
	public boolean moveable_right=false;
	public boolean moveable_left=true;
	private int velX;


	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getCachePos() {
		return cachePos;
	}

	public void setCachePos(int cachePos) {
		this.cachePos = cachePos;
	}

	public Player(int x, int y, int id,Texture tex) {
		
		super(x, y, id,tex);
		isAlive = true;
		x_pos = x;////
	}

	public int getX_pos() {
		return x_pos;
	}

	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;///
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public void tick() {
		x_pos += x_dis;
		x += velX;
		y += velY;
		if(x<=0)x=0;
		
		fall();
		checkCollision();
		
	}
	public void setX_dis(int x_dis) {
		this.x_dis = x_dis;
	}

	public int getX(){
		return x;
	}
	public void setX(int x1){
		x =x1;
	}	

	@Override
	public void render(Graphics g) {

		g.drawImage(tex.Ball,x,y,null);
	
	}
	private void checkCollision(){
		for(CoreObject obj : ALL){
			if(obj.getId()==Identities.BLOCK_STONE){
				block = (Block)obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					velY=0;
					y=block.getY()-Reference.ball_size_y;
					jumping=false;
					
				}
				if(getTopBounds().intersects(block.getBottomBounds())){
					y=block.getY()+32;
					velY=-velY;
				}			
			}
		}
		
	}
	
	public void fall(){
		if(falling)velY+=gravity;
	}
	
	/**
	 * get bounds
	 */
	public Rectangle getBottomBounds(){
		return new Rectangle(x+12,y+Reference.ball_size_y/2+6,Reference.ball_size_x-10,Reference.ball_size_y/2-5);
	}
	public Rectangle getTopBounds(){
		return new Rectangle(x+12,y+12,Reference.ball_size_x-10,Reference.ball_size_y/2-5);
	}
	public Rectangle getLeftBounds(){
		return new Rectangle(x+12,y+12,Reference.ball_size_x/2-5,Reference.ball_size_y-10);
	}
	public Rectangle getRightBounds(){
		return new Rectangle(x+Reference.ball_size_x/2+6,y+12,Reference.ball_size_x/2-5,Reference.ball_size_y-10);
	}
	/**
	 * 
	 * @return true if the player is jumping 
	 */
	public static boolean isJumping() {//jumping  changed to static
		return jumping;
	}
	/**
	 * 
	 * @param jumping the boolean to set the jumping state
	 */
	public static void setJumping(boolean j) {
		jumping = j;
	}
	
	public static void setLeftCollision(boolean L){//left &Right collision changed to static
		 leftCollision=L;
	}
	public static boolean isLeftCollision() {
		return leftCollision;
	}

	public static void setRightCollision(boolean R){
		 rightCollision=R;
	}
	public static boolean isRightCollision() {
		return rightCollision;
	}
}
