package monster;

import java.util.Random;

import entity.Entity;
import kachow.GamePanel;

public class Mon_Hawk extends Entity {

	GamePanel gp;
	
	public Mon_Hawk(GamePanel gp) {
		super(gp);
		this.gp = gp;

		name = "Hawk";
		speed = 12;
		maxLife = 99;
		life = maxLife;
		attack = 1;
		
		type = 2;
		
		direction = "left";
		
		solidArea.x = 0 * gp.scale;
		solidAreaDefaultX = solidArea.x;
		solidArea.y = 9 * gp.scale;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24 * gp.scale;
		solidArea.height = 6 * gp.scale;
		
		getImage();
		setAction();
	}
	
	public void getImage() {
		
		r1 = setup("/monsters/bird/r1.png");

		l1 = setup("/monsters/bird/l1.png");
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if (actionLockCounter == 120) {
			
			if (gp.player.worldY < this.worldY) {
				up = true;
				down = false;
			}
			
			if (gp.player.worldY > this.worldY) {
				down = true;
				up = false;
			}
			
			if (gp.player.worldX < this.worldX) {
				direction = "left"; 
				frames = 1; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
			}
			
			else if (gp.player.worldX > this.worldX) {
				direction = "right"; 
				frames = 1; 
				
				if (spriteNum > frames) {
					spriteNum = 1;
				}
				
				if (frames != temp ) {
					spriteNum = 1;
				}
				
				temp = frames;
			}
			
			actionLockCounter = 0;
			
		}
		
	}

}
