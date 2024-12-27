package kachow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.*;
import tile.TileManager;
import data.SaveLoad;

public class GamePanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int origTileSize = 24;
	public int scale = 4;
	
	public final int tileSize = origTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	public final int maxWorldCol = 160;
	public final int maxWorldRow = 10;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	int fps = 60;
	public int stage = 7, temp = 0;
	
	public TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Sound sound = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	public SaveLoad saveLoad = new SaveLoad(this);
	
	public Player player = new Player(this, keyH);
	public Entity npc[] = new Entity[10];
	public Entity obj[] = new Entity[50];

	public Entity monster[] = new Entity[30];
	public ArrayList<Entity> projectileList = new ArrayList<>();
	
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int gameOverState = 3;
	public final int cutsceneState = 4;
	private int cutsceneIndex = 0;
	private long cutsceneStartTime = 0;
	private long cutsceneDuration = 5000;
	
	private BufferedImage cut1, cut2, cut3;
	
	public long pauseStartTime, pauseTime = 0;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		this.requestFocusInWindow();
		
		try {
			cut1 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/1.png"));
			cut2 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/2.png"));
			cut3 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setupGame() {
		
		gameState = titleState;
		playMusic(0);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/fps;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {
			
			update();
			repaint();
			
			try {
				double remTime = (nextDrawTime - System.nanoTime()) / 1000000;
				
				if(remTime < 0) {
					remTime = 0;
				}
				
				Thread.sleep((long) remTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update() {
		
		System.out.println(player.fasterTemp);
		
		if (gameState == pauseState) {
			pauseTime = System.currentTimeMillis();
		}
		
		if (gameState == titleState) {
			ui.update();
			temp = 0;
			player.setDefaultValues();
		}
		
		if (gameState == playState) {
			
			//pauseTime = 0;
			
			if (temp != stage) {
				stopMusic();
				for (int i = 0; i < obj.length; i++) {
					if (obj[i] != null) {
						obj[i] = null;
					}
				}
				for (int i = 0; i < monster.length; i++) {
					if (monster[i] != null) {
						monster[i] = null;
					}
				}
				aSetter.setObject();
				aSetter.setMonster();
				temp = stage;
				player.life = 9;
				
				switch(stage) {
				case 1:
					playMusic(1);
					tileM.loadMap("/maps/map1.txt");
					break;
				case 2:
					playMusic(2);
					tileM.loadMap("/maps/map2.txt");
					break;
				case 3:
					playMusic(3);
					tileM.loadMap("/maps/map3.txt");
					break;
				case 4:
					playMusic(4);
					tileM.loadMap("/maps/map4.txt");
					break;
				case 5:
					playMusic(5);
					tileM.loadMap("/maps/map5.txt");
					break;
				case 6:
					playMusic(6);
					tileM.loadMap("/maps/map6.txt");
					break;
				case 7:
					playMusic(7);
					tileM.loadMap("/maps/map7.txt");
					break;
				case 8:
					playMusic(0);
					tileM.loadMap("/maps/map8.txt");
					cutsceneIndex = 1;
                    gameState = cutsceneState;
                    try {
            			cut1 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/4.png"));
            			cut2 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/5.png"));
            			cut3 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/6.png"));
            		} catch (IOException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    cutsceneStartTime = System.currentTimeMillis();                    
				}
			}
			
			player.update();
			
			for (int i = 0; i < npc.length; i++) {
				if (npc[i] != null) {
					npc[i].update();
				}
			}
			
			for (int i = 0; i < monster.length; i++) {
				if (monster[i] != null) {
					if (monster[i].alive) {
						monster[i].update();
					}
					if (!monster[i].alive) {
						monster[i] = null;
					}
				}
			}
			
			for (int i = 0; i < projectileList.size(); i++) {
				if (projectileList.get(i) != null) {
					if (projectileList.get(i).alive) {
						projectileList.get(i).update();
					}
					if (!projectileList.get(i).alive) {
						projectileList.remove(i);
					}
				}
			}
		}
		
		if (gameState == gameOverState && player.life != 9) {
			player.worldX = tileSize;
			player.worldY = tileSize * 6;
			player.life = 9;
			aSetter.setObject();
			
			player.direction = "idle right";
			player.isFaster = false;
			player.canDoubleJump = false;
			player.isInvisible = false;
			player.canAirSlash = false;
			
			player.speed = scale;
		}
		
		if (gameState == cutsceneState) {
			tileM.loadMap("/maps/def.txt");
	        long currentTime = System.currentTimeMillis();
	        if (currentTime - cutsceneStartTime >= cutsceneDuration) {
	            cutsceneIndex++;
	            cutsceneStartTime = currentTime;
	            if (stage == 8 && cutsceneIndex == 3) cutsceneDuration = 10000;
	            
	            if (cutsceneIndex > 3) {
	                if(stage == 8) {
	                	gameState = titleState;
	                	stage = 1;
	                	cutsceneIndex = 1;
	                	try {
	            			cut1 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/1.png"));
	            			cut2 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/2.png"));
	            			cut3 = ImageIO.read(getClass().getResourceAsStream("/cutscenes/3.png"));
	            		} catch (IOException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		}
	                	cutsceneDuration = 5000;
	                }
	                else {
	                	gameState = playState;
	                	cutsceneIndex = 0;
	                }
	            }
	        }
	    }
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		if (gameState == cutsceneState) {
	        BufferedImage currentCutscene = null;
	        switch (cutsceneIndex) {
	            case 1: currentCutscene = cut1; break;
	            case 2: currentCutscene = cut2; break;
	            case 3: currentCutscene = cut3; break;
	        }
	        if (currentCutscene != null) {
	            g2.drawImage(currentCutscene, 0, 0, screenWidth, screenHeight, null);
	        }
	    } else if (gameState == titleState ) {
			
			ui.draw(g2);
			
		} else {
			
			tileM.draw(g2);
			
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			
			for (int i = 0; i < npc.length; i++) {
				if (npc[i] != null) {
					npc[i].draw(g2);
				}
			}
			
			for (int i = 0; i < monster.length; i++) {
				if (monster[i] != null) {
					monster[i].draw(g2);
				}
			}
			
			for (int i = 0; i < projectileList.size(); i++) {
				if (projectileList.get(i) != null) {
					projectileList.get(i).draw(g2);
				}
			}
			
			player.draw(g2);
			
			ui.draw(g2);
			
			Toolkit.getDefaultToolkit().sync();
			g2.dispose();
			
		}
		
	}
	
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
		
	}
	
	public void stopMusic() {
		
		sound.stop();
		
	}
	
	public void playSFX(int i) {
		
		sound.setFile(i);
		sound.play();
		
	}

} 
