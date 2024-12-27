package kachow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import object.Obj_Heart;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font joy_40;
    BufferedImage ui, faster, doubleJump, airSlash, invisible, image, bg, go, dead;
    BufferedImage select, selectIcon1, selectIcon2, selectIcon3;
    BufferedImage heartFull, heartEmpty;
    BufferedImage[] timers, counts, titles;
    private long elapsedTime;
    public int spriteCounter = 0;
	public int spriteNum = 1;
	public int commandNum = 0;
	public int deadY = 96*7;
	private long gameOverStartTime = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        joy_40 = new Font("Joystix Monospace", Font.PLAIN, 40);

        try {
            ui = ImageIO.read(getClass().getResourceAsStream("/icons/ui.png"));

            faster = ImageIO.read(getClass().getResourceAsStream("/icons/fasterrun.png"));
            doubleJump = ImageIO.read(getClass().getResourceAsStream("/icons/doublejump.png"));
            airSlash = ImageIO.read(getClass().getResourceAsStream("/icons/airslash.png"));
            invisible = ImageIO.read(getClass().getResourceAsStream("/icons/invisible.png"));
            
            bg = ImageIO.read(getClass().getResourceAsStream("/title/titleScreen.png"));
            go = ImageIO.read(getClass().getResourceAsStream("/die/gameover.png"));
            dead = ImageIO.read(getClass().getResourceAsStream("/die/soul.png"));
            
            select = ImageIO.read(getClass().getResourceAsStream("/title/selectLeft.png"));
            selectIcon1 = ImageIO.read(getClass().getResourceAsStream("/title/selectRight1.png"));
            selectIcon2 = ImageIO.read(getClass().getResourceAsStream("/title/selectRight2.png"));
            selectIcon3 = ImageIO.read(getClass().getResourceAsStream("/title/selectRight3.png"));
            
            titles = new BufferedImage[] {
                    ImageIO.read(getClass().getResourceAsStream("/title/title1.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title2.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title3.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title4.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title5.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title6.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title7.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title8.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title9.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title10.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title11.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title12.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title13.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title14.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title15.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title16.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title17.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title18.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title19.png")),
                    ImageIO.read(getClass().getResourceAsStream("/title/title20.png"))
                };

            timers = new BufferedImage[] {
                ImageIO.read(getClass().getResourceAsStream("/icons/timer1.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer2.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer3.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer4.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer5.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer6.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer7.png")),
                ImageIO.read(getClass().getResourceAsStream("/icons/timer8.png"))
            };
            
            counts = new BufferedImage[] {
                    ImageIO.read(getClass().getResourceAsStream("/icons/count1.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count2.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count3.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count4.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count5.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count6.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count7.png")),
                    ImageIO.read(getClass().getResourceAsStream("/icons/count8.png"))
                };
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Entity heart = new Obj_Heart(gp);
        heartFull = heart.image;
        heartEmpty = heart.image2;
        
    }

    public void drawDashTimer(Graphics2D g2) {
        long elapsedTime = System.currentTimeMillis() - gp.player.dashStartTime;
        int timerIndex = (int) (elapsedTime / 1000 * 2);
 
        if (timerIndex >= 0 && timerIndex < timers.length) {
            g2.drawImage(timers[timerIndex], 334 * gp.scale, 176 * gp.scale, 
                         24 * gp.scale, 24 * gp.scale, null);
            g2.drawString(String.valueOf(5 - (timerIndex/2+1)), 342 * gp.scale, 192 * gp.scale);
        }
    }
    
    public void drawFasterTimer(Graphics2D g2, int x, int y) {
    	if (gp.player.isFaster) elapsedTime = System.currentTimeMillis() - gp.player.fasterStart;
    	
        int countIndex = (int) (elapsedTime / 1000);

        if (countIndex >= 0 && countIndex < counts.length) {
            g2.drawImage(counts[countIndex], x * gp.scale, y * gp.scale, 
                         18 * gp.scale, 18 * gp.scale, null);
        }
    }
    
    public void drawDblJumpTimer(Graphics2D g2, int x, int y) {
    	if (gp.player.canDoubleJump) elapsedTime = System.currentTimeMillis() - gp.player.dblJumpStart;
    	
        int countIndex = (int) (elapsedTime / 1000);

        if (countIndex >= 0 && countIndex < counts.length) {
            g2.drawImage(counts[countIndex], x * gp.scale, y * gp.scale, 
                         18 * gp.scale, 18 * gp.scale, null);
        }
    }
    
    public void drawAirSlashTimer(Graphics2D g2, int x, int y) {
    	if (gp.player.canAirSlash) elapsedTime = System.currentTimeMillis() - gp.player.airSlashStart;
    	
        int countIndex = (int) (elapsedTime / 1000);

        if (countIndex >= 0 && countIndex < counts.length) {
            g2.drawImage(counts[countIndex], x * gp.scale, y * gp.scale, 
                         18 * gp.scale, 18 * gp.scale, null);
        }
    }
    
    public void drawInvisibleTimer(Graphics2D g2, int x, int y) {
    	if (gp.player.isInvisible) elapsedTime = System.currentTimeMillis() - gp.player.invisibleStart;
    	
        int countIndex = (int) (elapsedTime / 1000);

        if (countIndex >= 0 && countIndex < counts.length) {
            g2.drawImage(counts[countIndex], x * gp.scale, y * gp.scale, 
                         18 * gp.scale, 18 * gp.scale, null);
        }
    }
    
    public void drawUI() {
    	
    	g2.drawImage(ui, 0, 0, gp.tileSize * 16, gp.tileSize * 9, null);
        drawDashTimer(g2);
        
        if (gp.player.isFaster) {
        	g2.drawImage(faster, 316 * gp.scale, 168 * gp.scale, 18 * gp.scale, 18 * gp.scale, null);
        	drawFasterTimer(g2, 316, 168);
        }
        
        if (gp.player.canDoubleJump) {
        	g2.drawImage(doubleJump, 327 * gp.scale, 153 * gp.scale, 18 * gp.scale, 18 * gp.scale, null);
        	drawDblJumpTimer(g2, 327, 153);
        }
        
        if (gp.player.canAirSlash) {
        	g2.drawImage(airSlash, 347 * gp.scale, 153 * gp.scale, 18 * gp.scale, 18 * gp.scale, null);
        	drawAirSlashTimer(g2, 347, 153);
        }
        
        if (gp.player.isInvisible) {
        	g2.drawImage(invisible, 358 * gp.scale, 168 * gp.scale, 18 * gp.scale, 18 * gp.scale, null);
        	drawInvisibleTimer(g2, 358, 168);
        }
    	
    }
    
    public void drawPauseScreen() {
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
        g2.setColor(Color.WHITE);
        String text = "PAUSED";
        int x = centeredText(text);
        int y = gp.tileSize * 3;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35F));
    	g2.setColor(Color.WHITE);
    	
    	text = "Continue";
    	x = centeredText(text);
    	y = 128*4;
    	if (commandNum == 0) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon1, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    	
    	text = "Exit to Title Screen";
    	x = centeredText(text);
    	y += gp.tileSize*2/3;
    	if (commandNum == 1) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon2, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    	
    	text = "Exit to Desktop";
    	x = centeredText(text);
    	y += gp.tileSize*2/3;
    	if (commandNum == 2) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon3, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    }

    
    public int centeredText(String text) {
    	int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    	return gp.screenWidth/2 - length/2;
    }
    
    public int centeredText2(String text) {
    	int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    	return gp.screenWidth/2/2 - length/2;
    }
    
    public int getTextLength(String text) {
    	return (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    }
    
    public void update() {
        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNum++;
            if (spriteNum > 20) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    
    public void drawTitleScreen() {
    	
    	if (spriteNum >= 1 && spriteNum <= titles.length) {
    	    image = titles[spriteNum - 1]; // Subtract 1 since arrays are 0-indexed
    	} else {
    	    // Fallback in case spriteNum is out of bounds
    	    image = null;
    	}
    	
    	g2.drawImage(bg, 0, 0, 384*gp.scale, 216*gp.scale, null);
    	g2.drawImage(image, 0, 0, 256*3, 144*3, null);
    	
    	g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35F));
    	g2.setColor(Color.BLACK);
    	
    	String text = "NEW GAME";
    	int x = centeredText2(text);
    	int y = 128*4;
    	if (commandNum == 0) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon1, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    	
    	text = "LOAD GAME";
    	x = centeredText2(text);
    	y += gp.tileSize*2/3;
    	if (commandNum == 1) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon2, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    	
    	text = "QUIT";
    	x = centeredText2(text);
    	y += gp.tileSize*2/3;
    	if (commandNum == 2) {
    		g2.drawImage(select, 0, y-45, x+getTextLength(text), gp.tileSize*2/3, null);
    		g2.drawImage(selectIcon3, x+getTextLength(text), y-45, gp.tileSize*2/3, gp.tileSize*2/3, null);
    	}
    	g2.drawString(text, x, y);
    	
    }
    
    public void drawPlayerLife() {
    	
    	int x = 61*gp.scale;
    	int y = 34*gp.scale;
    	int i = 0;
    	
    	while (i < gp.player.maxLife - 6) {
    		g2.drawImage(heartEmpty, x, y, null);
    		i++;
    		x += 12;
    		y -= 40;
    	}
    	
    	x = 3*gp.scale;
    	y = 44*gp.scale;
    	i++;
    	
    	while ((i >= gp.player.maxLife - 6) && (i <= gp.player.maxLife)) {
    		g2.drawImage(heartEmpty, x, y, null);
    		i++;
    		x += 44;
    	}
    	
    	x = 61*gp.scale;
    	y = 34*gp.scale;
    	i = 0;
    	
    	while (i < gp.player.life - 6) {
    		g2.drawImage(heartFull, x, y, null);
    		i++;
    		x += 12;
    		y -= 40;
    	}
    	
    	x = 3*gp.scale;
    	y = 44*gp.scale;
    	i++;
    	
    	while ((i >= gp.player.life - 6) && (i <= gp.player.life)) {
    		g2.drawImage(heartFull, x, y, null);
    		i++;
    		x += 44;
    	}
    	
    }
    
    public void drawGameOverScreen() {
    	
        if (gameOverStartTime == 0) {
            gameOverStartTime = System.currentTimeMillis();
            gp.stopMusic();
            gp.playMusic(0);
        }
        
        g2.drawImage(go, 0, 0, gp.screenWidth, gp.screenHeight, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
        String text = "GAME OVER";
        int x = centeredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);

        if ((spriteNum >= 1 && spriteNum <= titles.length)) {
            deadY--;
        }
        g2.drawImage(dead, gp.screenWidth / 2 - 48, deadY, gp.tileSize, gp.tileSize, null);

        long elapsedTime = System.currentTimeMillis() - gameOverStartTime;
        if (elapsedTime >= 7000) {
            gp.gameState = gp.titleState;
            gameOverStartTime = 0;
            gp.player.life = 9;
        	deadY = 96*7;
        	gp.temp = 0;
        }
    }

    public void draw(Graphics2D g2) {
    	this.g2 = g2;
    	
        g2.setFont(joy_40);
        g2.setColor(Color.WHITE);
        
        if (gp.gameState == gp.titleState) {
        	drawTitleScreen();
        }
        
        if (gp.gameState == gp.playState) {
        	drawUI();
        	drawPlayerLife();
        }
        
        if (gp.gameState == gp.pauseState) {
        	
        	drawPauseScreen();
        	
        }
        
        if (gp.gameState == gp.gameOverState) {
        	
        	drawGameOverScreen();
        	
        }
        
    }
}
