package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kachow.GamePanel;
import kachow.KeyHandler;
import kachow.UtilityTool;
import object.Obj_Slash;

public class Player extends Entity {
	
	KeyHandler keyH;
	
	private int frames = 0, temp = 0, run = 4, idle = 16, jump = 12, dash = 2, attack = 4, sit = 8;
	public long dashStartTime, dashTemp, dashEndTime = 0, attackStartTime, invisibleStart, fasterStart, dblJumpStart, airSlashStart;
	public long fasterTemp = 0, invisibleTemp = 0, dblJumpTemp = 0, airSlashTemp = 0;
	private int playerJumpSpeed, jumpNum = 0;
	private boolean jumpPressed = false;
	
	public int screenX, screenY;
	public int posX, poxY;         
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		type = 0;
		
		solidArea = new Rectangle();
		solidArea.x = 4 * gp.scale;
		solidAreaDefaultX = solidArea.x;
		solidArea.y = 10 * gp.scale;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 14 * gp.scale;
		solidArea.height = 13 * gp.scale;
		
		attackAreaL.width = 9 * gp.scale;
		attackAreaL.height = 15 * gp.scale;
		attackAreaL.x = 0;
		attackAreaL.y = 6;
		
		attackAreaR.width = 9 * gp.scale;
		attackAreaR.height = 15 * gp.scale;
		attackAreaR.x = 15;
		attackAreaR.y = 6;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		if (gp.stage == 5) {
			
			worldX = gp.tileSize * 158;
			worldY = gp.tileSize * 4;
			
		} else {
		
		worldX = gp.tileSize;
		worldY = gp.tileSize * 6;
		direction = "idle right";
		
		projectile = new Obj_Slash(gp);
		
		}
		isFaster = false;
		isInvisible = false;
		canDoubleJump = false;
		canAirSlash = false;
		canDash = true;
		playerJumpSpeed = 13;
		maxLife = 9;
		life = maxLife;
		speed = gp.scale;
		defSpeed = speed;
		
	}
	
	public void getPlayerImage() {
		
		plane = setup("/player/airplane.png", 2);
		
		r1 = setup("/player/run/r1.png");
		r2 = setup("/player/run/r2.png");
		r3 = setup("/player/run/r3.png");
		r4 = setup("/player/run/r4.png");

		l1 = setup("/player/run/l1.png");
		l2 = setup("/player/run/l2.png");
		l3 = setup("/player/run/l3.png");
		l4 = setup("/player/run/l4.png");

		ir1 = setup("/player/idle/r1.png");
		ir2 = setup("/player/idle/r2.png");
		ir3 = setup("/player/idle/r3.png");
		ir4 = setup("/player/idle/r4.png");
		ir5 = setup("/player/idle/r5.png");
		ir6 = setup("/player/idle/r6.png");
		ir7 = setup("/player/idle/r7.png");
		ir8 = setup("/player/idle/r8.png");
		ir9 = setup("/player/idle/r9.png");
		ir10 = setup("/player/idle/r10.png");
		ir11 = setup("/player/idle/r11.png");
		ir12 = setup("/player/idle/r12.png");
		ir13 = setup("/player/idle/r13.png");
		ir14 = setup("/player/idle/r14.png");
		ir15 = setup("/player/idle/r15.png");
		ir16 = setup("/player/idle/r16.png");

		il1 = setup("/player/idle/l1.png");
		il2 = setup("/player/idle/l2.png");
		il3 = setup("/player/idle/l3.png");
		il4 = setup("/player/idle/l4.png");
		il5 = setup("/player/idle/l5.png");
		il6 = setup("/player/idle/l6.png");
		il7 = setup("/player/idle/l7.png");
		il8 = setup("/player/idle/l8.png");
		il9 = setup("/player/idle/l9.png");
		il10 = setup("/player/idle/l10.png");
		il11 = setup("/player/idle/l11.png");
		il12 = setup("/player/idle/l12.png");
		il13 = setup("/player/idle/l13.png");
		il14 = setup("/player/idle/l14.png");
		il15 = setup("/player/idle/l15.png");
		il16 = setup("/player/idle/l16.png");

		jr1 = setup("/player/jump/r1.png");
		jr2 = setup("/player/jump/r2.png");
		jr3 = setup("/player/jump/r3.png");
		jr4 = setup("/player/jump/r4.png");
		jr5 = setup("/player/jump/r5.png");
		jr6 = setup("/player/jump/r6.png");
		jr7 = setup("/player/jump/r7.png");

		jl1 = setup("/player/jump/l1.png");
		jl2 = setup("/player/jump/l2.png");
		jl3 = setup("/player/jump/l3.png");
		jl4 = setup("/player/jump/l4.png");
		jl5 = setup("/player/jump/l5.png");
		jl6 = setup("/player/jump/l6.png");
		jl7 = setup("/player/jump/l7.png");

		dr1 = setup("/player/dash/r1.png");
		dr2 = setup("/player/dash/r2.png");

		dl1 = setup("/player/dash/l1.png");
		dl2 = setup("/player/dash/l2.png");

		ar1 = setup("/player/attack/r1.png");
		ar2 = setup("/player/attack/r2.png");
		ar3 = setup("/player/attack/r3.png");
		ar4 = setup("/player/attack/r4.png");

		al1 = setup("/player/attack/l1.png");
		al2 = setup("/player/attack/l2.png");
		al3 = setup("/player/attack/l3.png");
		al4 = setup("/player/attack/l4.png");

		sr1 = setup("/player/sit/r1.png");
		sr2 = setup("/player/sit/r2.png");
		sr3 = setup("/player/sit/r3.png");
		sr4 = setup("/player/sit/r4.png");
		sr5 = setup("/player/sit/r5.png");
		sr6 = setup("/player/sit/r6.png");
		sr7 = setup("/player/sit/r7.png");
		sr8 = setup("/player/sit/r8.png");

		sl1 = setup("/player/sit/l1.png");
		sl2 = setup("/player/sit/l2.png");
		sl3 = setup("/player/sit/l3.png");
		sl4 = setup("/player/sit/l4.png");
		sl5 = setup("/player/sit/l5.png");
		sl6 = setup("/player/sit/l6.png");
		sl7 = setup("/player/sit/l7.png");
		sl8 = setup("/player/sit/l8.png");

		
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
	
	public BufferedImage setup(String imageName, int scale) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
			image = uTool.scaleImage(image, gp.tileSize*scale, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
		
	}
	
	public void update() {

		if (worldX < 0) worldX = 0;
		if (worldX > gp.worldWidth - gp.tileSize) worldX = gp.worldWidth - gp.tileSize;

		collisionOn = false;
		gp.cChecker.checkTile(this);
		int objIndex = gp.cChecker.checkObject(this, true);
		pickupObject(objIndex);
		
		int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		interactNPC(npcIndex);
		
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		contactMonster(monsterIndex);
		
		if (gp.stage == 5) {
			
			if (solidArea.x == 4 * gp.scale) {
				solidArea.x = 5 * gp.scale;
				solidAreaDefaultX = solidArea.x;
				solidArea.y = 8 * gp.scale;
				solidAreaDefaultY = solidArea.y;
				solidArea.width = 33 * gp.scale;
				solidArea.height = 7 * gp.scale;
			}

			speed = gp.scale;
			
			if (worldY < 0) worldY = 0;
			if (worldY > gp.worldHeight - gp.tileSize) worldY = gp.worldHeight - gp.tileSize;

			worldX -= 4;
			
			if (keyH.up) {
				worldY -= speed;
			}
			
			if (keyH.down) {
				worldY += speed;
			}
			
			if (keyH.left) {
				worldX -= speed;
			}
			
			if (keyH.right) {
				worldX += 1;
			}
			
		} else {
			
			if (solidArea.x == 5 * gp.scale) {
				solidArea.x = 4 * gp.scale;
				solidAreaDefaultX = solidArea.x;
				solidArea.y = 10 * gp.scale;
				solidAreaDefaultY = solidArea.y;
				solidArea.width = 14 * gp.scale;
				solidArea.height = 13 * gp.scale;
			}
		
		if(isFaster && !isDashing) speed = gp.scale * 2;
		
		if (isFaster) {
			long i = 0;
			long currentTime = System.currentTimeMillis();
			if (gp.gameState == gp.pauseState) i = 0;
			if (gp.gameState == gp.playState) {
		        if (fasterTemp > 0 && i == 0) {
		            fasterStart = currentTime - fasterTemp;
		            fasterTemp = 0;
		        }
		        i++;
		    }
			
			if (currentTime - fasterStart > 8000) {
		        isFaster = false;
		        speed = defSpeed;
		    }
			
		}
		
		if (canDoubleJump) {
			long i = 0;
			long currentTime = System.currentTimeMillis();
			if (gp.gameState == gp.pauseState) i = 0;
			if (gp.gameState == gp.playState) {
		        if (dblJumpTemp > 0 && i == 0) {
		            dblJumpStart = currentTime - dblJumpTemp;
		            dblJumpTemp = 0;
		        }
		        i++;
		    }
			
			if (currentTime - dblJumpStart > 8000) {
				canDoubleJump = false;
		    }
			
		}
		
		if (canAirSlash) {
			long i = 0;
			long currentTime = System.currentTimeMillis();
			if (gp.gameState == gp.pauseState) i = 0;
			if (gp.gameState == gp.playState) {
		        if (airSlashTemp > 0 && i == 0) {
		            airSlashStart = currentTime - airSlashTemp;
		            airSlashTemp = 0;
		        }
		        i++;
		    }
			
			if (currentTime - airSlashStart > 8000) {
		        canAirSlash = false;
		    }
			
		}
		
		if ((keyH.right || keyH.left) && keyH.attack && !isJumping && !isDashing && !isFalling) {
			
			isSitting = false;
			
			frames = attack;
			
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			
			if (frames != temp ) {
				spriteNum = 1;
			}
			
			temp = frames;
			
			if (direction.contains("right")) {
				direction = "attack right";
			} else if (direction.contains("left")) {
				direction = "attack left";
			}
				
		} else if ((keyH.left || keyH.right) && !isAttacking) {
			
			isSitting = false;
			
			if (isJumping) {
				
				if (keyH.left) {
			        direction = "jump left";
			    } else if (keyH.right) {
			        direction = "jump right";
			    }
				
				frames = jump;
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				
			} else if (!keyH.jump && !isJumping && !isFalling) {
				
				if (keyH.right) {
			        direction = "right";
			    } else if (keyH.left) {
			        direction = "left";
			    }
				
				frames = run;
			
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				
				if (direction.contains("left")) {
			        direction = "left";
			    } else if (direction.contains("right")) {
			        direction = "right";
			    }
				
			} else if (isFalling) {
				
				spriteNum = 8;
				
				if (direction.contains("right")) {
					direction = "jump right";
				} else if (direction.contains("left")) {
					direction = "jump left";
				}
				
			}
			
			if (!collisionOn || (!collisionOn && isOnGround)) {
				if (direction.contains("left")) {
			        worldX -= speed;
			    } else if (direction.contains("right")) {
			    	worldX += speed;
			    }
			} else {
				
			}

		}
		
		if (!keyH.right && !keyH.left) {
			
			if (keyH.sit && !isJumping && !isDashing && !isAttacking) {
				isSitting = true;
				
				frames = sit;
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				
				if (direction.contains("right")) {
					direction = "sit right";
				} else if (direction.contains("left")) {
					direction = "sit left";
				}
			}
			
			if (keyH.jump) {
				
				isSitting = false;
				
				frames = jump;
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				
				if (direction.contains("right")) {
			        direction = "jump right";
			    } else if (direction.contains("left")) {
			        direction = "jump left";
			    }
				
			} else if (!keyH.jump && !isJumping && !isSitting) {
				
				if (keyH.attack) {
					
					isSitting = false;

					frames = attack;
					
					if (spriteNum > frames) {
						spriteNum = 1;
					}
					
					if (frames != temp ) {
						spriteNum = 1;
					}
					
					temp = frames;
					
				    if (direction.contains("right")) {
				        direction = "attack right";
				    } else if (direction.contains("left")) {
				        direction = "attack left";
				    }
					
				} else if (!isAttacking) {
					
					frames = idle;
					
					if (spriteNum > frames) {
						spriteNum = 1;
					}
					
					if (frames != temp ) {
						spriteNum = 1;
					}
					
					temp = frames;
					
				    if (direction.contains("right")) {
				        direction = "idle right";
				    } else if (direction.contains("left")) {
				        direction = "idle left";
				    }
					
				}
				
				
			}
		}

		if (keyH.jump && isOnGround) {
		    isJumping = true;
		    yVelocity = -playerJumpSpeed;
		    isOnGround = false;
		    if (isDashing) {
		    	if (direction.equals("jump right")) {
		            direction = "dash right";
		        } else if (direction.equals("jump left")) {
		            direction = "dash left";
		        }
		    } else {
		    	if (direction.contains("right")) {
			        direction = "jump right";
			    } else if (direction.contains("left")) {
			        direction = "jump left";
			    }
		    }
		}
		
		if (keyH.jump && !jumpPressed) {
		    jumpPressed = true;
		    
		    if (isOnGround) {
		        jumpNum = 1;
		        isJumping = true;
		        yVelocity = -playerJumpSpeed;
		        isOnGround = false;
		        direction = direction.contains("left") ? "jump left" : "jump right";
		    }
		    
		    if (jumpNum < 2 && canDoubleJump) {
		        jumpNum++;
		        spriteNum = 1;
		        isJumping = true;
		        yVelocity = -playerJumpSpeed;
		        direction = direction.contains("left") ? "jump left" : "jump right";
		    }
		}
		
		if (!keyH.jump) {
		    jumpPressed = false;
		}
		
		isFalling = !isOnGround && !isJumping;

		if (isOnGround) {
			jumpNum = 0;
		    yVelocity = 0;
		    isJumping = false;

		    if (!isJumping && !isDashing) {		    	
		        if (direction.equals("jump right")) {
		            direction = "idle right";
		        } else if (direction.equals("jump left")) {
		            direction = "idle left";
		        }
		    }
		    
		} else {
		    worldY += yVelocity;
		    yVelocity += gravity;

		    if (worldY >= gp.screenHeight - (gp.tileSize/2)) {
		        
		        worldX = gp.tileSize;
				worldY = gp.tileSize * 6;
				life--;
				gp.aSetter.setObject();
				
				isFaster = false;
				canDoubleJump = false;
				isInvisible = false;
				canAirSlash = false;
				
				speed = gp.scale;
		    }
		}

		if (keyH.dash && canDash && !isDashing && !isSitting && (keyH.right || keyH.left)) {
		    isDashing = true;
		    if (!isFaster) speed = gp.scale*3;
		    if (isFaster) speed = gp.scale*3*2;
		    dashStartTime = System.currentTimeMillis();
		    canDash = false;

		    if (!isJumping) {
		        frames = dash;
		        
		        if (direction.contains("right")) {
		            direction = "idle right";
		        } else if (direction.contains("left")) {
		            direction = "idle left";
		        }
		    }
		}


		if (isDashing && !direction.contains("idle")) {
		    long currentTime = System.currentTimeMillis();
		    
		    if (!isJumping) {
		    	
		    	if (direction.contains("right")) {
			        direction = "dash right";
			    } else if (direction.contains("left")) {
			        direction = "dash left";
			    }
		    	
				frames = dash;
				
				if (spriteNum > frames || frames != temp) {
	                spriteNum = 1;
	            }
				
	            temp = frames;
	            
		    }

		    if (currentTime - dashStartTime > 400) {
		        isDashing = false;
		        if (!isFaster) speed = gp.scale;
		        if (isFaster) speed = gp.scale*2;

		        if (!isJumping) {			    	
			        if (direction.contains("right")) {
			            direction = "idle right";
			        } else if (direction.contains("left")) {
			            direction = "idle left";
			        }
			    }
		    }
		}

		
		if (!canDash) {
			long i = 0;
			long currentTime = System.currentTimeMillis();
			if (gp.gameState == gp.pauseState) i = 0;
			if (gp.gameState == gp.playState) {
		        if (dashTemp > 0 && i == 0) {
		            dashStartTime = currentTime - dashTemp;
		            dashTemp = 0;
		        }
		        i++;
		    }
			
			if (currentTime - dashStartTime > 4000) {
		        canDash = true;
		    }
		}
		
		if (keyH.attack && !isAttacking && !isJumping && !isDashing && !isSitting) {
			isAttacking = true;
			attackStartTime = System.currentTimeMillis();
			
			spriteNum = 1;
		}
		
		if (isAttacking) {
			long currentTime = System.currentTimeMillis();
			
			if (currentTime - attackStartTime > 350) {
		        isAttacking = false;
		    }
			
		}
		
		if (isSitting) {
			if (direction.contains("right")) {
				direction = "sit right";
			} else if (direction.contains("left")) {
				direction = "sit left";
			}
		}
		
		if (isFalling && !isOnGround) {
			frames = jump;
			spriteNum = 8;
			if (direction.contains("right")) {
				direction = "jump right";
			} else if (direction.contains("left")) {
				direction = "jump left";
			}
		}
		
		if(isInvisible && direction.contains("right")) direction = "none right";
		if(isInvisible && direction.contains("left")) direction = "none left";
		
		if (isInvisible) {
			long i = 0;
			long currentTime = System.currentTimeMillis();
			if (gp.gameState == gp.pauseState) i = 0;
			if (gp.gameState == gp.playState) {
		        if (invisibleTemp > 0 && i == 0) {
		            invisibleStart = currentTime - invisibleTemp;
		            invisibleTemp = 0;
		        }
		        i++;
		    }
			
			if (currentTime - invisibleStart > 8000) {
		        isInvisible = false;
		    }
			
		}
		
		spriteCounter++;
		if(spriteCounter > 6) {
			spriteNum++;
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		if (isAttacking && spriteCounter > 1 && spriteCounter < 4) {
			
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			int solidAreaX = solidArea.x;
			int solidAreaY = solidArea.y;
			
			if (direction.contains("left")) {
				solidArea.width = 48;
				solidArea.height = 96;
				solidArea.x = 0;
				solidArea.y = 0;
			} else if (direction.contains("right")) {
				solidArea.width = 48;
				solidArea.height = 96;
				solidArea.x = 48;
				solidArea.y = 0;
			}

			monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			damageMonster(monsterIndex);

			// After checking collision, restore the original data
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
			solidArea.x = solidAreaX;
			solidArea.y = solidAreaY;

			
		}
		
		if (canAirSlash && !projectile.alive && keyH.attack) {
			
			projectile.set(worldX, worldY, direction, true, this);
			
			gp.projectileList.add(projectile);
			
		}
		}
		
		if (invincible == true) {
			invincibleCounter++;
			if (invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
		if(life <= 0) {
			gp.gameState = gp.gameOverState;
		}
		
	}
	
	public void contactMonster(int i) {
		if (i != 999) {
			
			if (invincible == false) {
				life -= gp.monster[i].attack;
				invincible = true;
			}
		} 
	}
	
	public void damageMonster(int i) {
		if (i != 999) {
			
			if (!gp.monster[i].invincible) {
				
				gp.monster[i].life --;
				gp.monster[i].invincible = true;
				gp.monster[i].damageReaction();
				
				if (gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
				}
				
			}
			
			System.out.println("Hit");
		} else {
			System.out.println("Miss");
		}
	}
	
	public void pickupObject(int i) {
		
		if(i != 999) {
			String objectName = gp.obj[i].name;
			
			switch (objectName) {
			case "Cat Food":
				isFaster = true;
				gp.obj[i] = null;
				fasterStart = System.currentTimeMillis();
				break;
			case "Fish":
				canDoubleJump = true;
				gp.obj[i] = null;
				dblJumpStart = System.currentTimeMillis();
				
				break;
			case "Leftovers":
				canAirSlash = true;
				airSlashStart = System.currentTimeMillis();
				gp.obj[i] = null;
				break;
			case "Hotdog":
				isInvisible = true;
				gp.obj[i] = null;
				invisibleStart = System.currentTimeMillis();
				break;
			case "Exit":
				gp.stage++;
				setDefaultValues();
				
				gp.saveLoad.save();
				
				break;
			}
		}
		
	}
	
	public void interactNPC (int i) {
		
		if (i != 999) {
			System.out.println("You are hitting an npc");
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		if (gp.stage == 5) {
			image = plane;
		} else {
				
		switch (direction) {
		case "right":
			switch (spriteNum) {
        		case 1: image = r1; break;
        		case 2: image = r2; break;
        		case 3: image = r3; break;
        		case 4: image = r4; break;
			}
			break;
		case "left":
			switch (spriteNum) {
    			case 1: image = l1; break;
    			case 2: image = l2; break;
    			case 3: image = l3; break;
    			case 4: image = l4; break;
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
		case "jump right":
			switch (spriteNum) {
            	case 1: image = jr1; break;
            	case 2: image = jr2; break;
            	case 3: image = jr3; break;
            	case 4: image = jr4; break;
            	case 5: image = jr5; break;
            	case 6: image = jr6; break;
            	case 7: case 8: case 9: case 10: case 11: case 12: image = jr7; break;
			}
			break;
		case "jump left":
			switch (spriteNum) {
            	case 1: image = jl1; break;
            	case 2: image = jl2; break;
            	case 3: image = jl3; break;
            	case 4: image = jl4; break;
            	case 5: image = jl5; break;
            	case 6: image = jl6; break;
            	case 7: case 8: case 9: case 10: case 11: case 12: image = jl7; break;
			}
			break;
		case "dash right":
			switch (spriteNum) {
		    	case 1: image = dr1; break;
		    	case 2: image = dr2; break;
			}
			break;
		case "dash left":
			switch (spriteNum) {
		    	case 1: image = dl1; break;
		    	case 2: image = dl2; break;
			}
			break;
		case "attack right":
			switch (spriteNum) {
        		case 1: image = ar1; break;
        		case 2: image = ar2; break;
        		case 3: image = ar3; break;
        		case 4: image = ar4; break;
			}
			break;
		case "attack left":
			switch (spriteNum) {
    			case 1: image = al1; break;
    			case 2: image = al2; break;
    			case 3: image = al3; break;
    			case 4: image = al4; break;
			}
			break;
		case "sit right":
		    switch (spriteNum) {
		        case 1: image = sr1; break;
		        case 2: image = sr2; break;
		        case 3: image = sr3; break;
		        case 4: image = sr4; break;
		        case 5: image = sr5; break;
		        case 6: image = sr6; break;
		        case 7: image = sr7; break;
		        case 8: image = sr8; break;
		    }
		    break;
		case "sit left":
		    switch (spriteNum) {
		        case 1: image = sl1; break;
		        case 2: image = sl2; break;
		        case 3: image = sl3; break;
		        case 4: image = sl4; break;
		        case 5: image = sl5; break;
		        case 6: image = sl6; break;
		        case 7: image = sl7; break;
		        case 8: image = sl8; break;
		    }
		    break;
		}
		}
		
		int x = screenX;

        if(screenX > worldX) {
            x = worldX;
        }
        int rightOffset = gp.screenWidth - screenX;
        if (rightOffset > gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        
        if(invincible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
				
		if (gp.stage == 5) g2.drawImage(image, x, worldY, gp.tileSize*2, gp.tileSize, null);
		else g2.drawImage(image, x, worldY, gp.tileSize, gp.tileSize, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}

}
