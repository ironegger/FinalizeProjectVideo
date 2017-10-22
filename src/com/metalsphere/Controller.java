package com.metalsphere;

import java.awt.Graphics;
import java.util.ArrayList;

import com.metalsphere.core.CoreObject;
import com.metalsphere.entity.Player;



public class Controller {
	
	private static ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
	public void tick(){
		for(CoreObject obj : objects)
			obj.tick();
		
	}
	public void render(Graphics g){
		for(CoreObject obj: objects)
			obj.render(g);
		
	}
	public static void addObject(CoreObject instance){
		objects.add(instance);
	}
	public static void removeObject(CoreObject instance){
		objects.remove(instance);
	}
	public void removeAll(){
		objects.clear();
	}
	
	public static ArrayList<CoreObject> getObjects(){
		return objects;
	}
}
