package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kachow.GamePanel;
import kachow.UtilityTool;

public class Entity {
	
	public int worldX, worldY;
	public int speed, defSpeed;
	public boolean isDashing = false, canDash = true, isJumping = false, isOnGround = true, isAttacking = false, isSitting = false, isFalling = false;
	public boolean canDoubleJump = false, isFaster = false, isInvisible = false, canAirSlash = false;
	public boolean up = false, down = false;
	
	public int frames, temp;
	
	public BufferedImage r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	public BufferedImage ir1, ir2, ir3, ir4, ir5, ir6, ir7, ir8, ir9, ir10, ir11, ir12, ir13, ir14, ir15, ir16;
	public BufferedImage il1, il2, il3, il4, il5, il6, il7, il8, il9, il10, il11, il12, il13, il14, il15, il16;
	public BufferedImage jr1, jr2, jr3, jr4, jr5, jr6, jr7;
	public BufferedImage jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	public BufferedImage dr1, dr2, dl1, dl2;
	public BufferedImage ar1, ar2, ar3, ar4, al1, al2, al3, al4;
	public BufferedImage sr1, sr2, sr3, sr4, sr5, sr6, sr7, sr8;
	public BufferedImage sl1, sl2, sl3, sl4, sl5, sl6, sl7, sl8;
	public BufferedImage left, right, object, mr1, mr2, mr3, mr4, mr5, ml1, ml2, ml3, ml4, ml5;
	public BufferedImage plane;

	public String direction = "idle right", prev;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea = new Rectangle(0, 0, 96, 96);
	public Rectangle attackAreaL = new Rectangle(0, 0, 0, 0);
	public Rectangle attackAreaR = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public Rectangle topArea = new Rectangle(0, 0, 0, 0);
	public int topAreaDefaultX, topAreaDefaultY;
	public boolean collisionOn = false;
	public double gravity = 0.6, yVelocity = 0;
	
	public int maxLife;
	public int life, attack;
	
	public boolean invincible = false;
	public int invincibleCounter = 0;
	
	int dyingCounter = 0;
	public boolean dying = false, alive = true;
	
	GamePanel gp;
	public UtilityTool uTool = new UtilityTool();
	
	public BufferedImage image, image2;
	public String name;
	public boolean collision = false;
	
	public int actionLockCounter = 0;
	
	public int type;
	
	public Projectile projectile;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
		
		mr1 = setup("/die/r1.png");
		mr2 = setup("/die/r2.png");
		mr3 = setup("/die/r3.png");
		mr4 = setup("/die/r4.png");
		mr5 = setup("/die/r5.png");

		ml1 = setup("/die/l1.png");
		ml2 = setup("/die/l2.png");
		ml3 = setup("/die/l3.png");
		ml4 = setup("/die/l4.png");
		ml5 = setup("/die/l5.png");
	}
	
	public void setAction() {}
	public void damageReaction() {}
	public void update() {
		
		if (worldX < 0) worldX = 0;
		if (worldX > gp.worldWidth - gp.tileSize) worldX = gp.worldWidth - gp.tileSize;
		
		setAction();
		
		if (!"Hawk".equals(name) && !"Human".equals(name)) {
	        collisionOn = false;

	        gp.cChecker.checkTile(this);
	        gp.cChecker.checkObject(this, false);
	        boolean contactPlayer = gp.cChecker.checkPlayer(this);
	        gp.cChecker.checkEntity(this, gp.monster);

	        if (this.type == 2 && contactPlayer) {
	            if (!gp.player.invincible) {
	                gp.player.life--;
	                gp.player.invincible = true;
	            }
	        }
	    }
		
		if (collisionOn == false) {
						
			switch (direction) {
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}
			
			if (up) worldY -= 3;
			if (down) worldY += 3;
		}
		
		spriteCounter++;
		if(spriteCounter > 6) {
			spriteNum++;
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		if (invincible == true) {
			invincibleCounter++;
			if (invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
	}
	
	public BufferedImage setup(String imageName) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
		
	}
	
	public BufferedImage setup(String imageName, int w, int h) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
			image = uTool.scaleImage(image, w, h);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
		
	}
	
	public void draw(Graphics2D g2, GamePanel gp) {
	    int screenX = worldX - gp.player.worldX + gp.player.screenX;
	    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX*31/16 && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX*31/16) {
	    	
	    	int x = screenX;

	        if(screenX > worldX) {
	            x = worldX;
	        }
	        int rightOffset = gp.screenWidth - screenX;
	        if (rightOffset > gp.worldWidth - worldX) {
	            x = gp.screenWidth - (gp.worldWidth - worldX);
	        }
	        
	        if (name == "Bus") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Car1") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Car2") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Car3") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Truck") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Van1") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);
	        else if (name == "Van2") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*2, null);

	        else if (name == "Cabinet") g2.drawImage(object, x, worldY, gp.tileSize*2, gp.tileSize*2, null);
	        else if (name == "Door") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*4, null);
	        else if (name == "Shelf") g2.drawImage(object, x, worldY, gp.tileSize*4, gp.tileSize*4, null);
	        else if (name == "Sofa") g2.drawImage(object, x, worldY, gp.tileSize*2, gp.tileSize*2, null);
	        
	        else g2.drawImage(object, x, worldY, gp.tileSize, gp.tileSize, null);
	    }
	}
	
	public void draw(Graphics2D g2) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
	    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX*31/16 && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX*31/16) {
	    	
	    	BufferedImage image = null;
			
			switch (direction) {
			case "right":
				switch (spriteNum) {
	        		case 1: image = r1; break;
	        		case 2: image = r2; break;
	        		case 3: image = r3; break;
	        		case 4: image = r4; break;
	        		case 5: image = r5; break;
	        		case 6: image = r6; break;
	        		case 7: image = r7; break;
	        		case 8: image = r8; break;
	        		case 9: image = r9; break;
	        		case 10: image = r10; break;
				}
				break;
			case "left":
				switch (spriteNum) {
	    			case 1: image = l1; break;
	    			case 2: image = l2; break;
	    			case 3: image = l3; break;
	    			case 4: image = l4; break;
	        		case 5: image = l5; break;
	        		case 6: image = l6; break;
	        		case 7: image = l7; break;
	        		case 8: image = l8; break;
	        		case 9: image = l9; break;
	        		case 10: image = l10; break;
				}
				break;
			case "idle right":
				switch (spriteNum) {
	            	case 1: image = ir1; break;
	            	case 2: image = ir2; break;
	            	case 3: image = ir3; break;
	            	case 4: image = ir4; break;
	            	case 5: image = ir5; break;
	            	case 6: image = ir6; break;
	            	case 7: image = ir7; break;
	            	case 8: image = ir8; break;
	            	case 9: image = ir9; break;
	            	case 10: image = ir10; break;
	            	case 11: image = ir11; break;
	            	case 12: image = ir12; break;
	            	case 13: image = ir13; break;
	            	case 14: image = ir14; break;
	            	case 15: image = ir15; break;
	            	case 16: image = ir16; break;
				}
				break;
			case "idle left":
				switch (spriteNum) {
	            	case 1: image = il1; break;
	            	case 2: image = il2; break;
	            	case 3: image = il3; break;
	            	case 4: image = il4; break;
	            	case 5: image = il5; break;
	            	case 6: image = il6; break;
	            	case 7: image = il7; break;
	            	case 8: image = il8; break;
	            	case 9: image = il9; break;
	            	case 10: image = il10; break;
	            	case 11: image = il11; break;
	            	case 12: image = il12; break;
	            	case 13: image = il13; break;
	            	case 14: image = il14; break;
	            	case 15: image = il15; break;
	            	case 16: image = il16; break;
				}
				break;
			case "die left":
				switch (spriteNum) {
	            	case 1: case 2: image = ml1; break;
	            	case 3: case 4: image = ml2; break;
	            	case 5: case 6: image = ml3; break;
	            	case 7: case 8: image = ml4; break;
	            	case 9: case 10: case 11: image = mr5;
	            	case 12:
	            		dying = false;
	    				alive = false;
	            		break;
				}
				break;
			case "die right":
				switch (spriteNum) {
				case 1: case 2: image = mr1; break;
            	case 3: case 4: image = mr2; break;
            	case 5: case 6: image = mr3; break;
            	case 7: case 8: image = mr4; break;
            	case 9: case 10: case 11: image = mr5;
            	case 12:
            		dying = false;
    				alive = false;
            		break;
				}
				break;
			}
			
			int x = screenX;

	        if(screenX > worldX) {
	            x = worldX;
	        }
	        int rightOffset = gp.screenWidth - screenX;
	        if (rightOffset > gp.worldWidth - worldX) {
	            x = gp.screenWidth - (gp.worldWidth - worldX);
	        }
			
	        if(invincible == true && life > 0) {
	            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
	        }
			
	        if (name == "Human") g2.drawImage(image, x, worldY, gp.tileSize*5, gp.tileSize*5, null);
	        else g2.drawImage(image, x, worldY, gp.tileSize, gp.tileSize, null);
			
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	    	
	    }
		
	}
	
	public void dyingAnimation() {
		
		dyingCounter++;
		System.out.println(dyingCounter);
		
		if (direction.contains("left")) {
			
			int i = 20;
			
			if (dyingCounter > 0 && dyingCounter <= i) image = ml1;
			if (dyingCounter > i && dyingCounter <= i*2) image = ml1;
			if (dyingCounter > i*2 && dyingCounter <= i*3) image = ml1;
			if (dyingCounter > i*3 && dyingCounter <= i*4) image = ml1;
			if (dyingCounter > i*4 && dyingCounter <= i*6) image = ml1;
			
			if (dyingCounter > i*6) {
				dying = false;
				alive = false;
			}
			
		} else if (direction.contains("right")) {
			
int 		i = 10;
			
			if (dyingCounter > 0 && dyingCounter <= i) image = mr1;
			if (dyingCounter > i && dyingCounter <= i*2) image = mr1;
			if (dyingCounter > i*2 && dyingCounter <= i*3) image = mr1;
			if (dyingCounter > i*3 && dyingCounter <= i*4) image = mr1;
			if (dyingCounter > i*4 && dyingCounter <= i*6) image = mr1;
			
			if (dyingCounter > i*6) {
				dying = false;
				alive = false;
			}
			
		}
		
	}
		
}
