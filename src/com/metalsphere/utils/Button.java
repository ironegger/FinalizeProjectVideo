package com.metalsphere.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


import com.metalsphere.input.MouseInput;




@SuppressWarnings("serial")
public class Button extends Rectangle {
	private String text;
	

	public Button() {
		super();
		
	}

	public Button(Rectangle r) {
		super(r);
		
	}

	public Button(Point p) {
		super(p);
		
	}

	public Button(Dimension d) {
		super(d);
		
	}

	public Button(int width, int height) {
		super(width, height);
		
	}

	public Button(Point p, Dimension d) {
		super(p, d);
		
	}

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	public Button setText(String text){
		this.text=text;
		return this;
	}
	public void drawButton(Graphics g,int offset){
		int xx=x + offset;
		int yy=y + 38;
		if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE !=null){
			 g.setColor(Color.WHITE);
			 g.drawRect(this.x-5,this.y-5,width+10,height+10);
			 g.drawString(text,xx,yy);
			 //AudioPlayer.getSound(Audio.menu_click).play();//
			 
		 }else if(!MouseInput.MOUSE.intersects(this)&&MouseInput.MOUSE!=null){
			 g.setColor(Color.WHITE);
			 g.drawRect(this.x,this.y,this.width,this.height);
			 g.drawString(text,xx,yy);
			 
	}
		if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
		{g.drawRect(x,y,width,height);g.setColor(Color.WHITE);
		g.drawString(text,xx,yy);}
		else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this))
			{g.fillRect(x,y,width,height);g.setColor(Color.BLACK);g.drawString(text,xx,yy);}
		//g.setColor(Color.WHITE);
		//g.drawString(text,xx,yy);

}
}
