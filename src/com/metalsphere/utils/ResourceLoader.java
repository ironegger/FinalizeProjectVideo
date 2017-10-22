package com.metalsphere.utils;

import java.io.IOException;

import com.metalsphere.libs.Audio;
import com.metalsphere.libs.Fonts;
import com.metalsphere.libs.Images;




public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();

	public static void loadImages() {
		try {
			Images.title = imageLoader.loadImage("title2.png");
			Images.menu_bg = imageLoader.loadImage("menu_bg5.png");
			Images.version=imageLoader.loadImage("version.png");
			Images.spritesheetTest=imageLoader.loadImage("test_spritesheet2_1.png");
			Images.stage_bg1=imageLoader.loadImage("stage1-0.png");
			Images.theBall=imageLoader.loadImage("theBall.png");
			Images.GameOverBg=imageLoader.loadImage("GameOver.png");
			Images.stage_bg2 = imageLoader.loadImage("stage2.png");
			Images.stage_bg3 = imageLoader.loadImage("stage3bg1.png");
			Images.coin_1 = imageLoader.loadImage("coin1.png");
			Images.alien_1 = imageLoader.loadImage("alien_1.png");
			Images.UFO = imageLoader.loadImage("ufo.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadFonts() {
		Fonts.addFont(new Fonts("Percy Pixel.ttf"));
	}
	public static void loadSound(){
		/**
		 * SoundEffect
		 */
		AudioPlayer.addSound(Audio.bit_bg,"bit_bg.ogg");
		AudioPlayer.addSound(Audio.SOUND_menu_click,"Menu_Selection_Click.ogg");
		AudioPlayer.addSound(Audio.hover,"hover.ogg");
		AudioPlayer.addSound(Audio.jump, "jump_01.ogg");
		AudioPlayer.addSound(Audio.coin, "coin.ogg");
		AudioPlayer.addSound(Audio.wohoo, "wohoo.ogg");
		AudioPlayer.addSound(Audio.die,"die.ogg");
		
		AudioPlayer.addSound(Audio.pause, "pause.ogg");
		AudioPlayer.addSound(Audio.seeyou, "seeyou.ogg");
		
		
		/**
		 * Music
		 */
		AudioPlayer.addMusic(Audio.MUSIC_theme,"theme.ogg");
		AudioPlayer.addMusic(Audio.MUSIC_stage1,"bit_bg.ogg");
		AudioPlayer.addMusic(Audio.GAMEOVER,"GameOver.ogg");
		AudioPlayer.addMusic(Audio.MUSIC_stage2, "stage2.ogg");
		AudioPlayer.addMusic(Audio.DEATH, "death.ogg");
		AudioPlayer.addMusic(Audio.stage, "stage.ogg");
		AudioPlayer.addMusic(Audio.world, "world.ogg");
	}
}
