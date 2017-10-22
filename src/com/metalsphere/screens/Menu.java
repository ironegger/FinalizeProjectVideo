package com.metalsphere.screens;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.metalsphere.Game;
import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Images;
import com.metalsphere.libs.Reference;
import com.metalsphere.utils.AudioPlayer;
import com.metalsphere.utils.Button;



public class Menu {
	public Button play,options,quit;
	private int width=300;
	private int height=50;
	private int init_size=33;
	private boolean musicPlayed=false;
	
	
	
 public  Menu(){
	 //int fillerY=350;
	 int fillerY=600;
	 play=new Button(Reference.CENTER_X+150,fillerY,width,height).setText("PLAY");
	 options=new Button(Reference.CENTER_X+150,fillerY+=60,width,height).setText("OPTIONS");
	 quit=new Button(Reference.CENTER_X+150,fillerY+=60,width,height).setText("QUIT");
	 
	 
 }
 public void drawButton(Graphics g,Rectangle rect,String text,int offsetX,int size){
	 Font Earth=new Font("Earth 2073.ttf",Font.BOLD,size);
	 g.setFont(Earth);

	 
	 
	 
	 g.drawString(text,rect.x+offsetX,rect.y+38);
 }
 public  void render(Graphics g){
	 
	 g.setColor(Color.BLACK);
	 g.drawImage(Images.menu_bg,0,100,1280,750,null);
	 //g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
	 g.drawImage(Images.title,200,150,null);
	 if(musicPlayed==false){
	 AudioPlayer.playMusic(Audio.MUSIC_theme);
	 musicPlayed=true;}
	 g.drawImage(Images.version,Game.WIDTH-300,Game.HEIGHT-150,130,30,null);
	 Font Earth=new Font("Percy Pixel",Font.BOLD, init_size);
	 g.setFont(Earth);
	 play.drawButton(g,95);
	 options.drawButton(g,65);
	 quit.drawButton(g,95);
	 
 }
 public void setMusicPlay(boolean t){
	 musicPlayed=t;
 }
}

