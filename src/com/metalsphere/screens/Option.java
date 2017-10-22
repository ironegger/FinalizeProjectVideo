

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



public class Option {
	//public Button play,options,quit;
	public static Button back;
	public static Button help;
	public static Button volup;
	public static Button voldown;
	public static Button mute;
	private int width=300;
	private int height=50;
	private int init_size=33;
	private boolean musicPlayed=false;



	public  Option(){

		int fillerY=600;

		help=new Button(Reference.CENTER_X,fillerY,width,height).setText("HELP");
		mute=new Button(Reference.CENTER_X,fillerY+=60,width,height).setText("Mute/UnMute");
		volup=new Button(Reference.CENTER_X,fillerY+=60,width/2-5,height).setText("VolUp");
		voldown=new Button(Reference.CENTER_X+width/2+5,fillerY+=0,width/2-5,height).setText("VolDn");
		back=new Button(Reference.CENTER_X,fillerY+=60,width,height).setText("BACK");
	}
	public void drawButton(Graphics g,Rectangle rect,String text,int offsetX,int size){
		Font Earth=new Font("Earth 2073.ttf",Font.BOLD,size);
		g.setFont(Earth);
		g.drawString(text,rect.x+offsetX,rect.y+38);
	}
	public  void render(Graphics g){

		g.setColor(Color.BLACK);
		g.drawImage(Images.menu_bg,0,100,1280,750,null);
		g.drawImage(Images.title,200,150,null);
		if(musicPlayed==false){

			musicPlayed=true;}
		g.drawImage(Images.version,Game.WIDTH-300,Game.HEIGHT-150,130,30,null);
		Font Earth=new Font("Percy Pixel",Font.BOLD, init_size);
		g.setFont(Earth);
		help.drawButton(g,95);
		back.drawButton(g,95);
		mute.drawButton(g,65);
		volup.drawButton(g,32);
		voldown.drawButton(g,32);
	}
}