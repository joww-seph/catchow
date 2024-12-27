package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Door extends Entity {
	
	public Obj_Door(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Door";
		object = setup("/objects/door.png", gp.tileSize*4, gp.tileSize*4);
		
		topArea.x = 23*4;
		topArea.y = 10*4;
		topArea.width = 48*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
