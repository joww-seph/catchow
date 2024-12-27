package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Leftovers extends Entity {
	
	GamePanel gp;
	
	public Obj_Leftovers(GamePanel gp, int x, int y) {
		super(gp);
		
		name = "Leftovers";
		object = setup("/objects/leftovers.png");
		
		solidArea.x = 2*4;
		solidArea.y = 15*4;
		solidArea.width = 22*4;
		solidArea.height = 10*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
