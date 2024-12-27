package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Truck extends Entity {
	
	public Obj_Truck(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Truck";
		object = setup("/objects/truck.png", gp.tileSize*4, gp.tileSize*2);
		collision = true;
		
		solidArea.x = 24*4;
		solidArea.y = 4*4;
		solidArea.width = 70*4;
		solidArea.height = 44*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		topArea.x = 24*4;
		topArea.y = 0*4;
		topArea.width = 70*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
