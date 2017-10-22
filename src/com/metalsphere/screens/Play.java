package com.metalsphere.screens;

import java.awt.Color;
import java.awt.Graphics;

import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Images;
import com.metalsphere.utils.AudioPlayer;



public class Play {
	private boolean musicPlayed=false;
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		if(musicPlayed==false){
			AudioPlayer.playMusic(Audio.MUSIC_stage1);
			musicPlayed=true;
		}
		
	}

}
