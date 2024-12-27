package monster;

import java.awt.Rectangle;
import java.util.Random;

import entity.Entity;
import kachow.GamePanel;

public class Mon_Mouse extends Entity {

	GamePanel gp;
	
	public Mon_Mouse(GamePanel gp) {
		super(gp);
		this.gp = gp;

		name = "Mouse";
		speed = 2;
		maxLife = 1;
		life = maxLife;
		attack = 1;
		
		type = 2;
		
		direction = "idle right";
		
		solidArea.x = 9 * gp.scale;
		solidAreaDefaultX = solidArea.x;
		solidArea.y = 15 * gp.scale;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 10 * gp.scale;
		solidArea.height = 9 * gp.scale;
		
		getImage();
		setAction();
	}
	
	public void getImage() {
		
		r1 = setup("/monsters/mouse/r1.png");
		r2 = setup("/monsters/mouse/r2.png");
		r3 = setup("/monsters/mouse/r3.png");
		r4 = setup("/monsters/mouse/r4.png");

		ir1 = setup("/monsters/mouse/r3.png");

	}
	
	public void setAction() {
		
		if (dying) {
			gp.player.life++;
		}
				
				if (gp.player.worldX - this.worldX < 768/2) {
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
				
				else {
					direction = "idle right"; 
					frames = 1; 
				
					if (spriteNum > frames) {
						spriteNum = 1;
					}
				
					if (frames != temp ) {
						spriteNum = 1;
					}
				
					temp = frames;
				}
	}
	
	public void damageReaction() {		
	}

}
