package com.metalsphere.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;



public class Fonts {
private static ArrayList<Fonts> fontList=new ArrayList<Fonts>();

private static String fontPath;

public Fonts(String filePath){
	fontPath=Reference.FONT_LOCATION+filePath;
	registerFont();
}

private void registerFont(){
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	try{
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File(fontPath)));
	}catch(Exception e){
		e.printStackTrace();
	}
}
/**
 * 
 * @param font
 */
public static void addFont(Fonts font){
	fontList.add(font);
}
}
