package com.metalsphere.gfx;

import java.awt.image.BufferedImage;

import com.metalsphere.libs.Images;
import com.metalsphere.utils.SpriteSheet;



public class Texture {
	
	private SpriteSheet sheetTest;
	private SpriteSheet character;//
	public BufferedImage blockStone;
	public BufferedImage blockRock;
	public BufferedImage blockLava;
	public BufferedImage Ball;
	public SpriteSheet Item;
	public BufferedImage Coin_1;
	public SpriteSheet Enemy;
	public BufferedImage Aliean_1;
	public SpriteSheet UFO;
	public BufferedImage ufo;
	public SpriteSheet Jump;
	public BufferedImage jump;
	public SpriteSheet Move;
	public BufferedImage move;
	
	public Texture (){
		sheetTest=new SpriteSheet(Images.spritesheetTest,32);
		character=new SpriteSheet(Images.theBall,64);//
		Item=new SpriteSheet(Images.coin_1,32);
		Enemy = new SpriteSheet(Images.alien_1,64);
		UFO = new SpriteSheet(Images.UFO,128);
		Jump=new SpriteSheet(Images.jump,664);
		Move = new SpriteSheet(Images.move,430);
		initTexture();
	}
	
	private void initTexture(){
		blockStone = sheetTest.getSprite(1,1);
		blockRock = sheetTest.getSprite(2,1);
		blockLava = sheetTest.getSprite(3, 1);
		Ball=character.getSprite(1,1);//
		Coin_1 = Item.getSprite(1, 1);
		Aliean_1= Enemy.getSprite(1,1);
		ufo = UFO.getSprite(1, 1);
	}
}
