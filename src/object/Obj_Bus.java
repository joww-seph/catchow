package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Bus extends Entity {
	
	public Obj_Bus(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Bus";
		object = setup("/objects/bus.png", gp.tileSize*4, gp.tileSize*2);
		collision = true;
		
		solidArea.x = 4*4;
		solidArea.y = 8*4;
		solidArea.width = 88*4;
		solidArea.height = 44*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		topArea.x = 4*4;
		topArea.y = 4*4;
		topArea.width = 88*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
