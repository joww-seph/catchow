package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Fish extends Entity {
	
	GamePanel gp;
	
	public Obj_Fish(GamePanel gp, int x, int y) {
		super(gp);
		
		name = "Fish";
		object = setup("/objects/fish.png");
		
		solidArea.x = 2*4;
		solidArea.y = 14*4;
		solidArea.width = 23*4;
		solidArea.height = 11*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
