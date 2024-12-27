package tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	
	public BufferedImage image;
	public boolean collision = false;
	
	public Tile() {
		
	}
	
	public Tile(String path) {
		try {
			
			this.image = ImageIO.read(getClass().getResourceAsStream(path));
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	} 
	
	public Tile(String path, boolean collision) {
		try {
			
			this.image = ImageIO.read(getClass().getResourceAsStream(path));
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		this.collision = collision;
	}

}
