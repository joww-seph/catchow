package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Sofa extends Entity {
	
	public Obj_Sofa(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Sofa";
		object = setup("/objects/sofa.png", gp.tileSize*2, gp.tileSize*2);
		
		topArea.x = 7*4;
		topArea.y = 18*4;
		topArea.width = 29*4;
		topArea.height = 2*4;
		topAreaDefaultX = topArea.x;
		topAreaDefaultY = topArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
