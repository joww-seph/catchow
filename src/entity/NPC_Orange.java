package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import kachow.GamePanel;
import kachow.UtilityTool;

public class NPC_Orange extends Entity {
	
	public NPC_Orange (GamePanel gp) {
		super(gp);
		
		direction = "idle left";
		speed = 5;
		
		getImage();
		
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
		
		if (actionLockCounter == 120) {
			
			Random random = new Random();
			int i = random.nextInt(4)+1;
			
			switch (i) {
			case 1: 
				direction = "left"; 
				frames = 4; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
				break;
			case 2: 
				direction = "right"; 
				frames = 4; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
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

}
