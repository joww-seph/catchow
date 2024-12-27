package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Van1 extends Entity {
	
	public Obj_Van1(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Van1";
		object = setup("/objects/van1.png", gp.tileSize*4, gp.tileSize*2);
		
		topArea.x = 30*4;
		topArea.y = 12*4;
		topArea.width = 42*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
