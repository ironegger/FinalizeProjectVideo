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



public class Over {

	public Button playagain,mainmenu,quit;
	private int width=300;
	private int height=50;
	private int init_size=33;
	private boolean musicPlayed=false;

	public  Over(){

		int fillerY=Game.WIDTH/2-150;
	 	playagain=new Button(Reference.CENTER_X-150,fillerY,width,height).setText("PLAY AGAIN");
	 	mainmenu=new Button(Reference.CENTER_X-150,fillerY+=60,width,height).setText("MAIN MENU");
	 	quit=new Button(Reference.CENTER_X-150,fillerY+=60,width,height).setText("QUIT");

	}

	public void drawButton(Graphics g,Rectangle rect,String text,int offsetX,int size){

		 Font Earth=new Font("Earth 2073.ttf",Font.BOLD,size);
		 g.setFont(Earth);
		 
		 g.drawString(text,rect.x+offsetX,rect.y+38);
 	}


 	public  void render(Graphics g){
	 
		 g.setColor(new Color(0,0,0));
		
		 g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
		 g.drawImage(Images.GameOverBg,0,0,1280,600,null);
		 g.drawImage(Images.Jack, 0, Game.HEIGHT-500, 320	, 203, null);

		 if(musicPlayed==false){
			 AudioPlayer.playMusic(Audio.DEATH);
			 musicPlayed=true;
		 }
		 
	
		
		 Font Earth=new Font("Percy Pixel",Font.BOLD, init_size);
		 g.setFont(Earth);
		 playagain.drawButton(g,55);
		 mainmenu.drawButton(g,65);
		 quit.drawButton(g,95);
	 
 	}

 	public void setMusicPlay(boolean t){
 		musicPlayed =t;
 	}





	}