package com.metalsphere;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.metalsphere.enums.GameState;
import com.metalsphere.enums.StageState;
import com.metalsphere.gfx.Renderer;
import com.metalsphere.gfx.Texture;
import com.metalsphere.input.KeyInput;
import com.metalsphere.input.MouseInput;
import com.metalsphere.libs.Reference;
import com.metalsphere.screens.Intermediate;
import com.metalsphere.screens.Menu;
import com.metalsphere.screens.Option;
import com.metalsphere.screens.Over;
import com.metalsphere.screens.Pause;
import com.metalsphere.screens.Play;
import com.metalsphere.screens.Victory;
import com.metalsphere.utils.ResourceLoader;

/**
 * 
 */


/**
 * @author xuxiaoshi
 *
 */
@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	private static JFrame frame=new JFrame();
	public static final int WIDTH=1280;
	public static final int HEIGHT=WIDTH/4*3;
	public static final String TITLE="MetalSphere";
	private static Game game=new Game();
	public static GameState state=GameState.MENU; 
	public static StageState stage = StageState.None;
	private Over over;
	private Pause pause;
	private StageState pStage;
	private Victory victory;
	private int score;
	private Option option;
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private boolean running=false;
	private Thread thread;//run() as secondary thread;
	private Renderer gfx;
	private Menu menu;
	private Play play;
	private Intermediate intermediate;
	private Controller controller = new Controller();//control all the game oobjects;
	private Texture tex;
	private StageGenerator stagegenerator = new StageGenerator();
	
	public int ball_speed_right;
	public int ball_speed_left;
	public int block_speed;
	private KeyInput key;
	
	
	public static Game getInstance(){
		return game;
	}
	
	public Menu getMenu(){
		return menu;
	}
	public Over getOver(){
		return over;
	}
	public Play getPlay(){
		return play;
	}
	public Pause getPause(){
		return pause;
	}
	public Victory getVictory() {
		
		return victory;
	}
	public Intermediate getIntermediate(){
		return intermediate;
	}
	public Controller getController(){
		return controller;
	}
	
	public StageGenerator getGenerator(){
		return stagegenerator;
	}
	public Option getOption(){
		return option;
	}
	public Texture getText(){
		return tex;
	}
	public void init(){
		ResourceLoader.loadFonts();
		ResourceLoader.loadSound();
		ResourceLoader.loadImages();
		tex=new Texture();
		menu=new Menu();
		play=new Play();
		over=new Over();
		gfx=new Renderer();
		pause = new Pause();
		option = new Option();
		victory = new Victory();
		intermediate = new Intermediate();
		MouseInput mouse=new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		Game.stage=StageState.Stage_1;
		stagegenerator.init();
		key = new KeyInput();
		
		
		this.addKeyListener(key);
	}
	
	public void tick(){
		if(state==GameState.GAME)
			controller.tick();
	}
	

	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.setColor(new Color(26,26,26));
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		
		
		/////////////////////////////////////////////////
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		/////////////////////////////////////////////////
		
		
		g.dispose();
		bs.show();
		
	}
	///
	public void run() {//gameloop
		init();
		long lastTime=System.nanoTime();
		
		final double numTicks=60.0;//60ticks per second
		double n=1000000000/numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			
			if(state == GameState.GAME){
				
				pStage = Game.stage;
				setScore(this.getInstance().getGenerator().getScore());
				if(Game.getInstance().getGenerator().getThisPlayer().getY()> HEIGHT || !Game.getInstance().getGenerator().
						getThisPlayer().isAlive()){
					
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					state = GameState.GAMEOVER;}
				if(Game.getInstance().getGenerator().getThisPlayer().getX()>=Reference.CENTER_X){
					ball_speed_right =0;
					ball_speed_left = -5;
					block_speed =-5;
				}
				else if(Game.getInstance().getGenerator().getThisPlayer().getX()>0){
					ball_speed_right=5;
					ball_speed_left = -5;
					block_speed=0;
				}
				else{
					ball_speed_right = 5;
					ball_speed_left = 0;
					block_speed = 0;
				}
				if(Game.getInstance().getGenerator().getThisPlayer().getX_pos()>Game.getInstance().getGenerator().getLength()){
					Game.getInstance().getGenerator().setEndTime(System.nanoTime());
					if(Game.stage == StageState.Stage_3)
						Game.state = GameState.VICTORY;
					else {Game.getInstance().state=GameState.INTERMEDIATE;
					if(Game.stage==StageState.Stage_1)
					Game.stage=StageState.Stage_2;
					else if(Game.stage==StageState.Stage_2)
					Game.stage = StageState.Stage_3;
					
				}
				}

				if(pStage!=Game.stage){///
					stagegenerator.init();
					///
				}///

			}
			long currentTime = System.nanoTime();
			delta += (currentTime-lastTime)/n;
			lastTime=currentTime;
			
			if(delta>=1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(ticks + " Ticks, FPS: " + frames);
				frame.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: "
						+ frames);
				ticks = 0;
				frames = 0;
			}
		}
		
		stop();
		}
	

	public static void main(String args[]){
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image icon=toolkit.getImage(Reference.RESOURCE_LOCATION+"icon.png");
		Image cursor=toolkit.getImage(Reference.RESOURCE_LOCATION+"cursor.png");
		frame.setTitle(TITLE);
		frame.setIconImage(icon);
		frame.setCursor(toolkit.createCustomCursor(cursor,new Point(frame.getX(),frame.getY()),"cursor"));
		frame.setBackground(Color.black);
		frame.add(game);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); 
		frame.setVisible(true);
		frame.pack();
		game.start();
		
		
	}
	
	private synchronized void start(){
		if(running)return;//if this game is running ,we dont wanna start it again
		else 
			running = true;
		thread=new Thread(this);
		thread.start();
	}//synchronized: this method has to finish before any other method to start
	
	private synchronized void stop(){
		if(!running)return;
		else
			running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}




}
