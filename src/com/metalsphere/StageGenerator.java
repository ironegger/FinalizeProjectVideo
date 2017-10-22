package com.metalsphere;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.newdawn.slick.Music;

import com.metalsphere.entity.Player;
import com.metalsphere.gfx.Texture;
import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Identities;
import com.metalsphere.libs.Images;
import com.metalsphere.libs.Reference;
import com.metalsphere.objects.Block;
import com.metalsphere.objects.Enemy;
import com.metalsphere.objects.Item;
import com.metalsphere.objects.Ufo;
import com.metalsphere.utils.AudioPlayer;



public class StageGenerator {

	public Block terrain_block;
	public BufferedImage bg_image;
	public boolean music_played;
	private int length;

	

	private Texture p_tex;
	private int score;//points earned
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score += score;
	}
	//timer needed?
	private long StartTime;
	private long duration;
	private long endTime;
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	private Player thisPlayer;
	
	
	
	public Player getThisPlayer() {
		return thisPlayer;
	}
	//initialize the stage, remove the old things
	public void init(){
		Game.getInstance().getController().removeAll();
		score = 0;
		Game.getInstance().getIntermediate().setMusicPlay(false);
		StartTime = System.nanoTime();
		music_played = false;
		p_tex =  Game.getInstance().getText();
		if(Game.getInstance().getGenerator().getThisPlayer()==null){
			thisPlayer = new Player(Reference.CENTER_X, Reference.CENTER_Y, 1, p_tex);//modify
			}
		else {
			thisPlayer.setX(Reference.CENTER_X);
			thisPlayer.setY(Reference.CENTER_Y);
			thisPlayer.setX_pos(Reference.CENTER_X);///
			length=1000000;
			thisPlayer.setAlive(true);
		}
		Controller.addObject(thisPlayer);
		generateTerrain();
	}
	public void render(Graphics g){
		renderBackground(g);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Earth 2073.ttf",Font.BOLD,40));
		g.drawString("score "+getScore(), Game.getInstance().WIDTH-300, 100);
		playMusic();
	}
	private void generateTerrain(){
		//draw different types of terrain in three stages.
		switch(Game.stage){
		case Stage_1:
			
			for(int k=0;k<50;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-182,Identities.BLOCK_STONE,p_tex,p_tex.blockStone));
			Controller.addObject(new Enemy(44*32, Game.HEIGHT-246, Identities.aliean_1, p_tex, p_tex.Aliean_1));
			
			for(int k = 53;k < 54;k++)Controller.addObject(new Item(k*32, Game.HEIGHT-360, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=56;k<115;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			
			for(int k = 70;k<100;k+=5)Controller.addObject(new Item(k*32, Game.HEIGHT-330, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=105;k<115;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			
			for(int k = 108;k<113;k++)Controller.addObject(new Item(k*32, Game.HEIGHT-330, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=107;k<115;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-214, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=109;k<115;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-246, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=121;k<165;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			
			for(int k =128;k<160;k+=8)Controller.addObject(new Item(k*32, Game.HEIGHT-280, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=185;k<200;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=160;k<188;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-332, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=203;k<210;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-270, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=213;k<220;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-350, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=223;k<230;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-430, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int j=0;j<5;j++){
				int k =233;			
				Controller.addObject(new Block((k++*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
				Controller.addObject(new Block((k*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			}
			
			for(int k = 223;k<230;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-500, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int j=0;j<5;j++){
				int k =237;			
				Controller.addObject(new Block((k++*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
				Controller.addObject(new Block((k*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			}
			for(int j=0;j<5;j++){
				int k =241;			
				Controller.addObject(new Block((k++*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
				Controller.addObject(new Block((k*32), Game.HEIGHT-150-j*32, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			}
			
			for(int k=450;k<500;k+=11)Controller.addObject(new Item(k*32, Game.HEIGHT-480, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=245;k<260;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));			
			for(int k=262;k<275;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			
			for(int k = 262;k<263;k+=5)Controller.addObject(new Item(k*32, Game.HEIGHT-282, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=275;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=276;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-214, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=280;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-246, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			
			for(int k=282;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-278, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=284;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-310, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=286;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-342, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=288;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-374, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=290;k<296;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-406, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			for(int k=295;k<325;k++)Controller.addObject(new Block(k*32, Game.HEIGHT-182, Identities.BLOCK_STONE, p_tex, p_tex.blockStone));
			Controller.addObject(new Ufo(309*32, Game.HEIGHT-246-32, Identities.ufo, p_tex, p_tex.ufo));
		
		
		length=310*32;
		break;
			
		case Stage_2:
			for(int k=0;k<=21;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-150,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));					
			for(int k=24;k<=26;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-200,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			
			for(int k = 24;k<26;k++)Controller.addObject(new Item(k*32, Game.HEIGHT-282, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=29;k<=33;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-250,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));				
			for(int k=37;k<=42;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-350,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			for(int k = 37;k<42;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-432, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=47;k<=53;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-300,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			for(int k = 47;k<53;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-390, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=57;k<=61;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-450,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));				
			for(int k=64;k<=69;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-410,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			for(int k = 64;k<69;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-532, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=75;k<=80;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-500,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));							
			for(int k=84;k<=89;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-650,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));	
			
			for(int k=93;k<=100;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-750,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			for(int k = 93;k<100;k+=3)Controller.addObject(new Item(k*32, Game.HEIGHT-800, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			
			for(int k=105;k<=106;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-500,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			for(int k = 119;k<111;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-420, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=110;k<=111;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-200,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));				
			for(int k=114;k<=115;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-300,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));
			
			for(int k = 114;k<115;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-380, Identities.ITEM, p_tex, p_tex.Coin_1));
			
			for(int k=119;k<=119;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-350,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));				
			for(int k=125;k<=150;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-530,Identities.BLOCK_STONE,p_tex,p_tex.blockRock));	
			Controller.addObject(new Ufo(147*32, Game.HEIGHT-594-32, Identities.ufo, p_tex, p_tex.ufo));
			length=148*32;
			break;	
			
		case Stage_3:
		for(int k=15;k<=20;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-400,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 21;k<22;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-300, Identities.ITEM, p_tex, p_tex.Coin_1));
		for(int i=0;i<5;i++)Controller.addObject(new Block(22*32,Game.HEIGHT-22-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 25;k<26;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-400, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<5;i++)Controller.addObject(new Block(27*32,Game.HEIGHT-72-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 31;k<32;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-400, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<5;i++)Controller.addObject(new Block(33*32,Game.HEIGHT-72-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int i=0;i<5;i++)Controller.addObject(new Block(38*32,Game.HEIGHT-122-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 42;k<43;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-500, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<11;i++)Controller.addObject(new Block(42*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 47;k<48;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-700, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<16;i++)Controller.addObject(new Block(47*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int i=0;i<21;i++)Controller.addObject(new Block(52*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int k = 53;k<54;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-800, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<11;i++)Controller.addObject(new Block(56*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));	
		for(int i=0;i<11;i++)Controller.addObject(new Block(61*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 63;k<64;k+=2)Controller.addObject(new Item(k*32, Game.HEIGHT-600, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int i=0;i<16;i++)Controller.addObject(new Block(66*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));		
		for(int i=0;i<5;i++)Controller.addObject(new Block(72*32,Game.HEIGHT-22-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));				
		for(int i=0;i<5;i++)Controller.addObject(new Block(78*32,Game.HEIGHT-152-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		
		for(int k = 82;k < 100;k+=7)Controller.addObject(new Item(k*32, Game.HEIGHT-412, Identities.ITEM, p_tex, p_tex.Coin_1));
		
		for(int k=82;k<=100;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-312,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int i=0;i<5;i++)Controller.addObject(new Block(103*32,Game.HEIGHT-152-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int i=0;i<5;i++)Controller.addObject(new Block(104*32,Game.HEIGHT-152-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int k=107;k<117;k++)for(int i=0;i<5;i++)Controller.addObject(new Block(k*32,Game.HEIGHT-22-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int k=121;k<138;k+=3)for(int i=k-121;i<=k-121+6;i++)Controller.addObject(new Block(k*32,Game.HEIGHT-82-i*32,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		for(int k=145;k<160;k++)Controller.addObject(new Block(k*32,Game.HEIGHT-152,Identities.BLOCK_STONE,p_tex,p_tex.blockLava));
		length=150*32;
		Controller.addObject(new Ufo(149*32, Game.HEIGHT-216-32, Identities.ufo, p_tex, p_tex.ufo));
			break;
		default:
			break;

		}			
		}
	private void playMusic(){
		//keep music playing
		if(!music_played && thisPlayer.isAlive()&&thisPlayer.getY()<=Game.HEIGHT){
		switch(Game.stage){
		case Stage_1:
			AudioPlayer.playMusic(Audio.MUSIC_stage1);
			
			break;
		case Stage_2:
			AudioPlayer.playMusic(Audio.MUSIC_stage2);
			break;
		case Stage_3:
			AudioPlayer.playMusic(Audio.MUSIC_stage3);
			break;
		default:
			break;
			
		}
		}
		
		else if((!thisPlayer.isAlive()||thisPlayer.getY()>Game.HEIGHT))			
			AudioPlayer.playSoundEffect("die");
		music_played = true;
	}
	//set background pics
	private void renderBackground(Graphics g){
		switch(Game.stage){
		case Stage_1:
			g.drawImage(Images.stage_bg1, 0, 0, 1280,1000,null);
			break;
		case Stage_2:
			g.drawImage(Images.stage_bg2, 0, 0, 1280, 1000, null);
			break;
		case Stage_3:
			g.drawImage(Images.stage_bg3,0,0,1280,1000,null);
			break;
		default:
			break;
		}
	}
	//return the length of the stage
	public int getLength(){
		return length;
	}
	//set the length of the stage
	public void setLength(int i){
		length+=i;
	}
		
	}

	

