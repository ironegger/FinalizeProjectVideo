package com.metalsphere.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.metalsphere.libs.Reference;



public class BufferedImageLoader {

	private BufferedImage image;
	
	public BufferedImage loadImage(String imagePath) throws IOException{
		image=ImageIO.read(new File(Reference.SPRITE_LOCATION+imagePath));
		return image;
	}

}