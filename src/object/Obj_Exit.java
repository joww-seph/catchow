package object;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Exit extends Entity {
	
GamePanel gp;
	
	public Obj_Exit(GamePanel gp, int x, int y) {
		super(gp);
		
		name = "Exit";
		object = setup("/objects/exit.png");
		
		worldX = x * gp.tileSize;
		worldY = y * gp.tileSize;
	}

}
