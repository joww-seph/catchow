package monster;

import java.awt.Rectangle;
import java.util.Random;

import entity.Entity;
import kachow.GamePanel;

public class Mon_Garfield extends Entity {

	GamePanel gp;
	
	public Mon_Garfield(GamePanel gp) {
		super(gp);
		this.gp = gp;

		name = "Garfield";
		speed = 4;
		maxLife = 3;
		life = maxLife;
		attack = 2;
		
		type = 2;
		
		direction = "idle left";
		
		solidArea.x = 4 * gp.scale;
		solidAreaDefaultX = solidArea.x;
		solidArea.y = 10 * gp.scale;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 14 * gp.scale;
		solidArea.height = 13 * gp.scale;
		
		getImage();
		setAction();
	}
	
	public void getImage() {
		
		r1 = setup("/npc/garfield/run/r1.png");
		r2 = setup("/npc/garfield/run/r2.png");
		r3 = setup("/npc/garfield/run/r3.png");
		r4 = setup("/npc/garfield/run/r4.png");

		l1 = setup("/npc/garfield/run/l1.png");
		l2 = setup("/npc/garfield/run/l2.png");
		l3 = setup("/npc/garfield/run/l3.png");
		l4 = setup("/npc/garfield/run/l4.png");

		ir1 = setup("/npc/garfield/idle/r1.png");
		ir2 = setup("/npc/garfield/idle/r2.png");
		ir3 = setup("/npc/garfield/idle/r3.png");
		ir4 = setup("/npc/garfield/idle/r4.png");
		ir5 = setup("/npc/garfield/idle/r5.png");
		ir6 = setup("/npc/garfield/idle/r6.png");
		ir7 = setup("/npc/garfield/idle/r7.png");
		ir8 = setup("/npc/garfield/idle/r8.png");
		ir9 = setup("/npc/garfield/idle/r9.png");
		ir10 = setup("/npc/garfield/idle/r10.png");
		ir11 = setup("/npc/garfield/idle/r11.png");
		ir12 = setup("/npc/garfield/idle/r12.png");
		ir13 = setup("/npc/garfield/idle/r13.png");
		ir14 = setup("/npc/garfield/idle/r14.png");
		ir15 = setup("/npc/garfield/idle/r15.png");
		ir16 = setup("/npc/garfield/idle/r16.png");

		il1 = setup("/npc/garfield/idle/l1.png");
		il2 = setup("/npc/garfield/idle/l2.png");
		il3 = setup("/npc/garfield/idle/l3.png");
		il4 = setup("/npc/garfield/idle/l4.png");
		il5 = setup("/npc/garfield/idle/l5.png");
		il6 = setup("/npc/garfield/idle/l6.png");
		il7 = setup("/npc/garfield/idle/l7.png");
		il8 = setup("/npc/garfield/idle/l8.png");
		il9 = setup("/npc/garfield/idle/l9.png");
		il10 = setup("/npc/garfield/idle/l10.png");
		il11 = setup("/npc/garfield/idle/l11.png");
		il12 = setup("/npc/garfield/idle/l12.png");
		il13 = setup("/npc/garfield/idle/l13.png");
		il14 = setup("/npc/garfield/idle/l14.png");
		il15 = setup("/npc/garfield/idle/l15.png");
		il16 = setup("/npc/garfield/idle/l16.png");

	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if (dying) {
			
			solidArea = new Rectangle(0, 0, 0, 0);

			if (direction.contains("left")) {
				direction = "die left";
			} else if (direction.contains("right")) {
				direction = "die right";
			}
			
			frames = 12; 
			
			if (spriteNum > frames) {
				spriteNum = 1;
			}
			
			if (frames != temp ) {
				spriteNum = 1;
			}
			
			temp = frames;
			
		}
		
		else if (actionLockCounter == 60) {
			
			Random random = new Random();
			int i = random.nextInt(4)+1;
			
			switch (i) {
			case 1:
			case 2: 
				if (gp.player.worldX < this.worldX && gp.player.worldX - this.worldX > -768*2) {
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
				
				else if (gp.player.worldX > this.worldX && gp.player.worldX - this.worldX < 768*2) {
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
				break;
			case 3: 
				direction = "idle left"; 
				frames = 16; 
				
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
				frames = 16; 
				
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
		
//		actionLockCounter = 0;
//		if (direction.contains("left")) {
//			direction = "right"; 
//			frames = 4; 
//			
//			if (spriteNum > frames) {
//				spriteNum = 1;
//			}
//			
//			if (frames != temp ) {
//				spriteNum = 1;
//			}
//			
//			temp = frames;
//		}
//		if (direction.contains("right")) {
//			direction = "left"; 
//			frames = 4; 
//			
//			if (spriteNum > frames) {
//				spriteNum = 1;
//			}
//			
//			if (frames != temp ) {
//				spriteNum = 1;
//			}
//			
//			temp = frames;
//		}
		
	}

}