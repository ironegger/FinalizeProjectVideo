package com.metalsphere.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.metalsphere.Game;
import com.metalsphere.libs.Images;
import com.metalsphere.libs.Reference;
import com.metalsphere.utils.Button;

public class Help {
	public Button back;
	private int width=300;
	private int height=50;
	private int init_size=33;
	private boolean musicPlayed=false;

	public  Help(){

		int fillerY=Game.WIDTH/2-150;
	 	
	 	back=new Button(Reference.CENTER_X-150,fillerY+=60,width,height).setText("BACK");

	}

	public void drawButton(Graphics g,Rectangle rect,String text,int offsetX,int size){

		 Font Earth=new Font("Earth 2073.ttf",Font.BOLD,size);
		 g.setFont(Earth);
		 
		 g.drawString(text,rect.x+offsetX,rect.y+38);
 	}


 	public  void render(Graphics g){
	 
		 g.setColor(new Color(0,0,0));
		
		 g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
		 g.drawImage(Images.Error, 0,0,1200,600,null);
		 g.setColor(Color.WHITE);
		 g.setFont(new Font("Earth 2073.ttf",Font.BOLD,30));
		 g.drawString("A,D,SPACE control", Reference.CENTER_X-160, Reference.CENTER_Y+150);
		 g.drawString("developed by:", Reference.CENTER_X-160, Reference.CENTER_Y+200);
		 g.setFont(new Font("Earth 2073.ttf",Font.BOLD,20));
		 g.drawString("Xiaoshi Xu", Reference.CENTER_X-90, Reference.CENTER_Y+250);
		 g.drawString("Zhen Pei", Reference.CENTER_X-90, Reference.CENTER_Y+280);
		 g.drawString("Zhihuan Zhang", Reference.CENTER_X-90, Reference.CENTER_Y+310);
		 g.drawString("Lucy Morcos", Reference.CENTER_X-90, Reference.CENTER_Y+340);

		 if(musicPlayed==false){
			 //AudioPlayer.playMusic(Audio.stage);
			 musicPlayed=true;
		 }
		 
	
		
		 Font Earth=new Font("Percy Pixel",Font.BOLD, init_size);
		 g.setFont(Earth);
		// next.drawButton(g,55);
		// mainmenu.drawButton(g,65);
		 back.drawButton(g,95);
	 
 	}

 	public void setMusicPlay(boolean t){
 		musicPlayed =t;
 	}
}
