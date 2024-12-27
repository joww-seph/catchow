package object;

import entity.Projectile;
import kachow.GamePanel;

public class Obj_Slash extends Projectile {
	
	GamePanel gp;

	public Obj_Slash(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Slash";
		speed = 12;
		maxLife = 30;
		life = maxLife;
		
		alive = false;
		getImage();
		
		solidArea.x = 7 * gp.scale;
		solidAreaDefaultX = solidArea.x;
		solidArea.y = 2 * gp.scale;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 10 * gp.scale;
		solidArea.height = 21 * gp.scale;
	}
	
	public void getImage() {
		
		r1 = setup("/projectiles/right.png");
		l1 = setup("/projectiles/left.png");
		
	}

}
