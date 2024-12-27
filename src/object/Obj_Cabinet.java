package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Cabinet extends Entity {
	
	public Obj_Cabinet(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Cabinet";
		object = setup("/objects/cabinet.png", gp.tileSize*2, gp.tileSize*2);
		
		topArea.x = 0*4;
		topArea.y = 8*4;
		topArea.width = 48*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
