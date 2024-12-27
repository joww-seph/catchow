package monster;

import java.util.Random;

import entity.Entity;
import kachow.GamePanel;

public class Mon_Human extends Entity {

	GamePanel gp;
	
	public Mon_Human(GamePanel gp) {
		super(gp);
		this.gp = gp;

		name = "Human";
		speed = 3;
		maxLife = 99;
		life = maxLife;
		attack = 3;
		
		type = 2;
		
		direction = "idle left";
		
		getImage();
		setAction();
	}
	
	public void getImage() {
		
		r1 = setup("/npc/human/walk/r1.png");
		r2 = setup("/npc/human/walk/r2.png");
		r3 = setup("/npc/human/walk/r3.png");
		r4 = setup("/npc/human/walk/r4.png");
		r5 = setup("/npc/human/walk/r5.png");
		r6 = setup("/npc/human/walk/r6.png");
		r7 = setup("/npc/human/walk/r7.png");
		r8 = setup("/npc/human/walk/r8.png");
		r9 = setup("/npc/human/walk/r9.png");
		r10 = setup("/npc/human/walk/r10.png");

		l1 = setup("/npc/human/walk/l1.png");
		l2 = setup("/npc/human/walk/l2.png");
		l3 = setup("/npc/human/walk/l3.png");
		l4 = setup("/npc/human/walk/l4.png");
		l5 = setup("/npc/human/walk/l5.png");
		l6 = setup("/npc/human/walk/l6.png");
		l7 = setup("/npc/human/walk/l7.png");
		l8 = setup("/npc/human/walk/l8.png");
		l9 = setup("/npc/human/walk/l9.png");
		l10 = setup("/npc/human/walk/l10.png");

		ir1 = setup("/npc/human/idle/r1.png");

		il1 = setup("/npc/human/idle/l1.png");

	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if (actionLockCounter == 240) {
			
			Random random = new Random();
			int i = random.nextInt(4)+1;
			
			switch (i) {
			case 1:
			case 2: 
				if (gp.player.worldX < this.worldX && gp.player.worldX - this.worldX > -768*4) {
					direction = "left";
					
					solidArea.x = 0 * (gp.tileSize*5) / 128;
					solidAreaDefaultX = solidArea.x;
					solidArea.y = 62 * (gp.tileSize*5) / 128;
					solidAreaDefaultY = solidArea.y;
					solidArea.width = 81 * (gp.tileSize*5) / 128;
					solidArea.height = 66 * (gp.tileSize*5) / 128;
					
					frames = 10; 
					
					if (spriteNum > frames) {
						spriteNum = 1;
					}
					
					if (frames != temp ) {
						spriteNum = 1;
					}
					
					temp = frames;
				}
				
				else if (gp.player.worldX > this.worldX && gp.player.worldX - this.worldX < 768*4) {
					direction = "right"; 
					
					solidArea.x = 47 * (gp.tileSize*5) / 128;
					solidAreaDefaultX = solidArea.x;
					solidArea.y = 62 * (gp.tileSize*5) / 128;
					solidAreaDefaultY = solidArea.y;
					solidArea.width = 81 * (gp.tileSize*5) / 128;
					solidArea.height = 66 * (gp.tileSize*5) / 128;
					
					frames = 10; 
					
					if (spriteNum > frames) {
						spriteNum = 1;
					}
					
					if (frames != temp ) {
						spriteNum = 1;
					}
					
					temp = frames;
				}
				break;
			case 3: 
				direction = "idle left"; 
				
				solidArea.x = 0 * (gp.tileSize*5) / 128;
				solidAreaDefaultX = solidArea.x;
				solidArea.y = 62 * (gp.tileSize*5) / 128;
				solidAreaDefaultY = solidArea.y;
				solidArea.width = 81 * (gp.tileSize*5) / 128;
				solidArea.height = 66 * (gp.tileSize*5) / 128;
				
				frames = 1; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				break;
			case 4: 
				direction = "idle right"; 
				
				solidArea.x = 47 * (gp.tileSize*5) / 128;
				solidAreaDefaultX = solidArea.x;
				solidArea.y = 62 * (gp.tileSize*5) / 128;
				solidAreaDefaultY = solidArea.y;
				solidArea.width = 81 * (gp.tileSize*5) / 128;
				solidArea.height = 66 * (gp.tileSize*5) / 128;
				
				frames = 1; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				break;
			}
			actionLockCounter = 0;
		}
		
	}
	
	public void damageReaction() {
		
		actionLockCounter = 0;
		if (direction.contains("left")) {
			direction = "right"; 
			frames = 4; 
			
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			
			if (frames != temp ) {
				spriteNum = 1;
			}
			
			temp = frames;
		}
		if (direction.contains("right")) {
			direction = "left"; 
			frames = 4; 
			
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			
			if (frames != temp ) {
				spriteNum = 1;
			}
			
			temp = frames;
		}
		
	}

}
