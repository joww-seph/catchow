package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Hotdog extends Entity {
	
	GamePanel gp;
	
	public Obj_Hotdog(GamePanel gp, int x, int y) {
		super(gp);
		
		name = "Hotdog";
		object = setup("/objects/hotdog.png");
		
		solidArea.x = 6*4;
		solidArea.y = 21*4;
		solidArea.width = 14*4;
		solidArea.height = 4*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
