package com.metalsphere.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.metalsphere.Game;
import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Reference;
import com.metalsphere.utils.AudioPlayer;
import com.metalsphere.utils.Button;



public class Intermediate {
	public Button next,mainmenu,quit;
	private int width=300;
	private int height=50;
	private int init_size=33;
	private boolean musicPlayed=false;

	public  Intermediate(){
		// draw next mainmenu quit button
		int fillerY=Game.WIDTH/2-150;
	 	next=new Button(Reference.CENTER_X-150,fillerY,width,height).setText("NEXT");
	 	mainmenu=new Button(Reference.CENTER_X-150,fillerY+=60,width,height).setText("MAIN MENU");
	 	quit=new Button(Reference.CENTER_X-150,fillerY+=60,width,height).setText("QUIT");

	}
	
	public void drawButton(Graphics g,Rectangle rect,String text,int offsetX,int size){

		 Font Earth=new Font("Earth 2073.ttf",Font.BOLD,size);
		 g.setFont(Earth);
		 
		 g.drawString(text,rect.x+offsetX,rect.y+38);
 	}

	// draw bg add button add bgm
 	public  void render(Graphics g){
	 
		 g.setColor(new Color(0,0,0));
		
		 g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
		 g.setColor(Color.WHITE);
		 g.setFont(new Font("Earth 2073.ttf",Font.BOLD, 50));
		 g.drawString("POINTS:  "+Game.getInstance().getScore(), Reference.CENTER_X-120, Reference.CENTER_Y-100);
		 g.drawImage(Images.notbad,0,Game.HEIGHT-500,364,375,null);


		 if(musicPlayed==false){
			 AudioPlayer.playMusic(Audio.stage);
			 musicPlayed=true;
		 }
		 
	
		
		 Font Earth=new Font("Percy Pixel",Font.BOLD, init_size);
		 g.setFont(Earth);
		 next.drawButton(g,55);
		 mainmenu.drawButton(g,65);
		 quit.drawButton(g,95);
	 
 	}
	// music setting
 	public void setMusicPlay(boolean t){
 		musicPlayed =t;
 	}

}
