package tile;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import kachow.GamePanel;
import kachow.UtilityTool;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[100];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		switch(gp.stage) {
		case 1:
			loadMap("/maps/map1.txt");
			break;
		case 2:
			loadMap("/maps/map2.txt");
			break;
		}

	}
	public void getTileImage() {

		setup(0, "nullTile", false);
		
		setup(1, "level1/suburbs1", false);
		setup(2, "level1/suburbs2", false);
		setup(3, "level1/suburbs3", false);
		setup(4, "level1/suburbs4", false);
		setup(5, "level1/suburbs5", false);
		setup(6, "level1/land1", false);
		setup(7, "level1/land2", true);
		setup(8, "level1/pitLeft1", false);
		setup(9, "level1/pitCenter1", false);
		setup(10, "level1/pitRight1", false);
		setup(11, "level1/pitLeft2", false);
		setup(12, "level1/pitCenter2", false);
		setup(13, "level1/pitRight2", false);
		setup(14, "level1/pitLeft3", false);
		setup(15, "level1/pitCenter3", false);
		setup(16, "level1/pitRight3", false);
		setup(17, "level1/sign", true);
		
		setup(21, "level2/rooftops1", false);
		setup(22, "level2/rooftops2", false);
		setup(23, "level2/rooftops3", false);
		setup(24, "level2/rooftops4", false);
		setup(25, "level2/rooftops5", false);
		setup(26, "level2/rooftopLeft1", true);
		setup(27, "level2/rooftopCenter1", true);
		setup(28, "level2/rooftopRight1", true);
		setup(29, "level2/rooftopLeft2", true);
		setup(30, "level2/rooftopCenter2", true);
		setup(31, "level2/rooftopRight2", true);
		setup(32, "level2/window1", true);
		setup(33, "level2/window2", true);
		setup(34, "level2/window3", true);

		setup(41, "level3/bridge1", false);
		setup(42, "level3/bridge2", false);
		setup(43, "level3/bridge3", false);
		setup(44, "level3/bridge4", false);
		setup(45, "level3/bridge5", false);
		setup(46, "level3/bridgeTopLeft", false);
		setup(47, "level3/bridgeTopRight", false);
		setup(48, "level3/bridgeLeft1", true);
		setup(49, "level3/bridgeCenter", true);
		setup(50, "level3/bridgeRight1", true);
		setup(51, "level3/bridgeLeft2", true);
		setup(52, "level3/bridgeRight2", true);
		setup(53, "level3/platform1", true);
		setup(54, "level3/platform2", true);
		setup(55, "level3/suspensionLeft1", false);
		setup(56, "level3/suspensionLeft2", false);
		setup(57, "level3/suspensionRight1", false);
		setup(58, "level3/suspensionRight2", false);
		
		setup(61, "level4/highway1", false);
		setup(62, "level4/highway2", false);
		setup(63, "level4/highway3", false);
		setup(64, "level4/highway4", false);
		setup(65, "level4/highway5", false);
		
		setup(71, "level5/sky1", false);
		setup(72, "level5/sky2", false);
		setup(73, "level5/sky3", false);
		
		setup(81, "level6/backalley1", false);
		setup(82, "level6/backalley2", false);
		setup(83, "level6/backalley3", false);
		setup(84, "level6/backalley4", false);
		setup(85, "level6/backalley5", false);
		
		setup(91, "level7/apartment1", false);
		setup(92, "level7/apartment2", false);
		setup(93, "level7/apartment3", false);
		setup(94, "level7/apartment4", false);
		setup(95, "level7/apartment5", false);

		setup(99, "black", true);

		
	}
	
	public void setup(int index, String imagePath, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try  {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath + ".png"));
			if (index >= 1 && index <= 5){
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize*16*2, (gp.tileSize*6)+(16*gp.scale));
			} else if ((index >= 21 && index <= 25) ||
					(index >= 41 && index <= 45) ||
					(index >= 71 && index <= 73)) {
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize*16*2, gp.tileSize*9);
			} else if (index >= 61 && index <= 65){
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize*16*2, (gp.tileSize*7)+(16*gp.scale));
			} else if (index >= 81 && index <= 85 ||
					(index >= 91 && index <= 95)){
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize*16*2, gp.tileSize*8);
			} else {
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			}
			tile[index].collision = collision;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String filePath) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0, row = 0;
			
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while (col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			br.close();
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void draw (Graphics g2) {
		
		int worldCol = 0, worldRow = 0;
		
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			
			int x = screenX;

	        if(screenX > worldX) {
	            x = worldX;
	        }
	        int rightOffset = gp.screenWidth - screenX;
	        if (rightOffset > gp.worldWidth - worldX) {
	            x = gp.screenWidth - (gp.worldWidth - worldX);
	        }
			
			if ((tileNum >= 1 && tileNum <= 5)) {
				g2.drawImage(tile[tileNum].image, x, worldY, gp.tileSize*16*2, (gp.tileSize*6)+(16*gp.scale), null);
			}
			
			if ((tileNum >= 21 && tileNum <= 25) || 
					(tileNum >= 41 && tileNum <= 45) ||
					(tileNum >= 71 && tileNum <= 73)) {
				g2.drawImage(tile[tileNum].image, x, worldY, gp.tileSize*16*2, gp.tileSize*9, null);
			} 
			
			if ((tileNum >= 61 && tileNum <= 65)) {
				g2.drawImage(tile[tileNum].image, x, worldY, gp.tileSize*16*2, (gp.tileSize*7)+(16*gp.scale), null);
			}
			
			if ((tileNum >= 81 && tileNum <= 85) || 
					(tileNum >= 91 && tileNum <= 95)) {
				g2.drawImage(tile[tileNum].image, x, worldY, gp.tileSize*16*2, (gp.tileSize*8), null);
			}

			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX*31/16 && 
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX*31/16) {
				
				if (!((tileNum >= 1 && tileNum <= 5) ||
						(tileNum >= 21 && tileNum <= 25) || 
						(tileNum >= 41 && tileNum <= 45) || 
						(tileNum >= 61 && tileNum <= 65) ||
						(tileNum >= 71 && tileNum <= 73) || 
						(tileNum >= 81 && tileNum <= 85) || 
						(tileNum >= 91 && tileNum <= 95))) {
					g2.drawImage(tile[tileNum].image, x, worldY, gp.tileSize, gp.tileSize, null);
				}
				
			}
			
			worldCol++;
			
			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
			
		}
		
	}

}
