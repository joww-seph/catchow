package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Car3 extends Entity {
	
	public Obj_Car3(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Car3";
		object = setup("/objects/car3.png", gp.tileSize*4, gp.tileSize*2);
		
		topArea.x = 38*4;
		topArea.y = 18*4;
		topArea.width = 28*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
