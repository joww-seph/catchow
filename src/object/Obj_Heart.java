package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import kachow.GamePanel;

public class Obj_Heart extends Entity {
	
	public Obj_Heart(GamePanel gp) {
		super(gp);
		
		name = "Heart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/icons/life.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/icons/noLife.png"));
			image = uTool.scaleImage(image, 9*gp.scale, 8*gp.scale);
			image2 = uTool.scaleImage(image2, 9*gp.scale, 8*gp.scale);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
