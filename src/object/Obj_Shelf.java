package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Shelf extends Entity {
	
	public Obj_Shelf(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Shelf";
		object = setup("/objects/shelf.png", gp.tileSize*4, gp.tileSize*4);
		
		topArea.x = 21*4;
		topArea.y = 11*4;
		topArea.width = 50*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
