package com.metalsphere.libs;

import com.metalsphere.Game;

public class Reference {

	public static final int CENTER_X=Game.WIDTH/2;
	public static final int CENTER_Y=Game.HEIGHT/2;
	
	
	public static final String RESOURCE_LOCATION="./resources/";
	public static final String SPRITE_LOCATION=RESOURCE_LOCATION+"sprites/";
	public static final String FONT_LOCATION=RESOURCE_LOCATION+"fonts/";
	/**
	 * base loaction of sound folder
	 */
	public static final String SOUND_LOCATION=RESOURCE_LOCATION+"sounds/";

	
	
	/**
	 * Player status
	 */
	public static int velJump = -20;
	public static int ball_size_x=50;
	public static int ball_size_y=50;
	
	/**
	 * Stage constant
	 */
	public static double ST1_GRAVITY=1;
}