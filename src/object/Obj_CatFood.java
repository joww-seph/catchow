package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_CatFood extends Entity {
	
	public Obj_CatFood(GamePanel gp, int x, int y) {
		
		super(gp);
		
		name = "Cat Food";
		object = setup("/objects/cat food.png");
		
		solidArea.x = 6*4;
		solidArea.y = 12*4;
		solidArea.width = 14*4;
		solidArea.height = 13*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
