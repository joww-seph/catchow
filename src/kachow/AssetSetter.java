package kachow;

import monster.Mon_Garfield;
import monster.Mon_Hawk;
import monster.Mon_Human;
import monster.Mon_Milky;
import object.Obj_Bus;
import object.Obj_Cabinet;
import object.Obj_Car1;
import object.Obj_Car2;
import object.Obj_Car3;
import object.Obj_CatFood;
import object.Obj_Door;
import object.Obj_Hotdog;
import object.Obj_Fish;
import object.Obj_Leftovers;
import object.Obj_Shelf;
import object.Obj_Sofa;
import object.Obj_Truck;
import object.Obj_Van1;
import object.Obj_Van2;
import object.Obj_Exit;

public class AssetSetter {
	
	GamePanel gp;
	
  	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		switch(gp.stage) {
		case 1:
			gp.obj[0] = new Obj_CatFood(gp, 9, 6);
			gp.obj[1] = new Obj_Fish(gp, 30, 6);
			gp.obj[2] = new Obj_Fish(gp, 77, 6);
			gp.obj[3] = new Obj_Fish(gp, 131, 6);
			gp.obj[4] = new Obj_CatFood(gp, 143, 6);
			gp.obj[5] = new Obj_Exit(gp, 158, 5);
			gp.obj[6] = new Obj_Exit(gp, 158, 6);
			
			break;
		case 2:
			gp.obj[0] = new Obj_Hotdog(gp, 9, 6);
			gp.obj[1] = new Obj_Fish(gp, 26, 7);
			gp.obj[2] = new Obj_CatFood(gp, 66, 6);
			gp.obj[3] = new Obj_Fish(gp, 136, 7);
			gp.obj[4] = new Obj_Exit(gp, 158, 5);
			gp.obj[5] = new Obj_Exit(gp, 158, 6);
			gp.obj[6] = new Obj_Hotdog(gp, 103, 6);
			gp.obj[7] = new Obj_Leftovers(gp, 122, 4);
			
			break;
		case 3:
			gp.obj[0] = new Obj_Fish(gp, 4, 5);
			gp.obj[1] = new Obj_Fish(gp, 29, 6);
			gp.obj[2] = new Obj_Fish(gp, 57, 6);
			gp.obj[3] = new Obj_CatFood(gp, 85, 6);
			gp.obj[4] = new Obj_Fish(gp, 113, 6);
			gp.obj[5] = new Obj_Hotdog(gp, 141, 6);
			gp.obj[6] = new Obj_Exit(gp, 158, 5);
			gp.obj[7] = new Obj_Exit(gp, 158, 4);
			
			break;
		case 4:
			gp.obj[0] = new Obj_Van1(gp, 1, 6);
			gp.obj[1] = new Obj_Truck(gp, 5, 6);
			gp.obj[2] = new Obj_Car2(gp, 13, 6);
			gp.obj[3] = new Obj_Bus(gp, 17, 6);
			gp.obj[4] = new Obj_Van1(gp, 27, 6);
			gp.obj[5] = new Obj_Car1(gp, 30, 6);
			gp.obj[6] = new Obj_Car2(gp, 33, 6);
			gp.obj[7] = new Obj_Bus(gp, 37, 6);
			gp.obj[8] = new Obj_Car3(gp, 48, 6);
			gp.obj[9] = new Obj_Van2(gp, 51, 6);
			gp.obj[10] = new Obj_Truck(gp, 55, 6);
			gp.obj[11] = new Obj_Bus(gp, 61, 6);
			gp.obj[12] = new Obj_Bus(gp, 69, 6);
			gp.obj[14] = new Obj_Car1(gp, 73, 6);
			gp.obj[15] = new Obj_Truck(gp, 77, 6);
			gp.obj[16] = new Obj_Van1(gp, 81, 6);
			gp.obj[17] = new Obj_Car3(gp, 89, 6);
			gp.obj[18] = new Obj_Bus(gp, 93, 6);
			gp.obj[19] = new Obj_Car2(gp, 99, 6);
			gp.obj[20] = new Obj_Van2(gp, 103, 6);
			gp.obj[21] = new Obj_Bus(gp, 110, 6);
			gp.obj[22] = new Obj_Bus(gp, 117, 6);
			gp.obj[23] = new Obj_Car3(gp, 128, 6);
			gp.obj[24] = new Obj_Car1(gp, 132, 6);
			gp.obj[25] = new Obj_Car2(gp, 135, 6);
			gp.obj[26] = new Obj_Car2(gp, 138, 6);
			gp.obj[27] = new Obj_Car3(gp, 141, 6);
			gp.obj[28] = new Obj_Van2(gp, 145, 6);
			gp.obj[29] = new Obj_Van1(gp, 148, 6);
			gp.obj[30] = new Obj_Bus(gp, 152, 6);
			gp.obj[31] = new Obj_Exit(gp, 158, 7);
			gp.obj[32] = new Obj_Exit(gp, 158, 6);
			
			gp.obj[13] = new Obj_Fish(gp, 60, 7);
			gp.obj[33] = new Obj_Leftovers(gp, 0, 7);
			gp.obj[34] = new Obj_CatFood(gp, 12, 7);
			gp.obj[35] = new Obj_Leftovers(gp, 127, 7);
			gp.obj[36] = new Obj_Leftovers(gp, 88, 7);
			
			break;
		case 5:
			gp.obj[0] = new Obj_Exit(gp, 0, 0);
			gp.obj[1] = new Obj_Exit(gp, 0, 1);
			gp.obj[2] = new Obj_Exit(gp, 0, 2);
			gp.obj[3] = new Obj_Exit(gp, 0, 3);
			gp.obj[4] = new Obj_Exit(gp, 0, 4);
			gp.obj[5] = new Obj_Exit(gp, 0, 5);
			gp.obj[6] = new Obj_Exit(gp, 0, 6);
			gp.obj[7] = new Obj_Exit(gp, 0, 7);
			gp.obj[8] = new Obj_Exit(gp, 0, 8);
			
			break;
		case 6:
			gp.obj[0] = new Obj_Exit(gp, 158, 6);
			gp.obj[1] = new Obj_Exit(gp, 158, 7);

			gp.obj[2] = new Obj_Leftovers(gp, 0, 7);
			gp.obj[3] = new Obj_Leftovers(gp, 20, 7);
			gp.obj[4] = new Obj_Leftovers(gp, 40, 7);
			gp.obj[5] = new Obj_Leftovers(gp, 60, 7);
			gp.obj[6] = new Obj_Leftovers(gp, 80, 7);
			gp.obj[7] = new Obj_Leftovers(gp, 100, 7);
			gp.obj[8] = new Obj_Leftovers(gp, 120, 7);
			gp.obj[9] = new Obj_Leftovers(gp, 140, 7);
			
			gp.obj[10] = new Obj_Fish(gp, 10, 7);
			gp.obj[11] = new Obj_Hotdog(gp, 30, 7);
			gp.obj[12] = new Obj_Hotdog(gp, 50, 7);
			gp.obj[13] = new Obj_Hotdog(gp, 70, 7);
			gp.obj[14] = new Obj_Fish(gp, 90, 7);
			gp.obj[15] = new Obj_Fish(gp, 110, 7);
			gp.obj[16] = new Obj_Hotdog(gp, 130, 7);
			gp.obj[17] = new Obj_Hotdog(gp, 150, 7);
			
			break;
		case 7:
			gp.obj[0] = new Obj_Cabinet(gp, 7, 6);
			gp.obj[1] = new Obj_Sofa(gp, 5, 6);
			gp.obj[2] = new Obj_Door(gp, 9, 4);
			gp.obj[3] = new Obj_Shelf(gp, 14, 4);
			gp.obj[4] = new Obj_Door(gp, 19, 4);
			gp.obj[5] = new Obj_Cabinet(gp, 22, 6);
			gp.obj[6] = new Obj_Cabinet(gp, 25, 6);
			gp.obj[7] = new Obj_Door(gp, 27, 4);
			gp.obj[8] = new Obj_Cabinet(gp, 31, 6);
			gp.obj[9] = new Obj_Sofa(gp, 35, 6);
			gp.obj[10] = new Obj_Sofa(gp, 37, 6);
			gp.obj[11] = new Obj_Shelf(gp, 39, 4);
			gp.obj[12] = new Obj_Cabinet(gp, 44, 6);
			gp.obj[13] = new Obj_Sofa(gp, 46, 6);
			gp.obj[14] = new Obj_Door(gp, 48, 4);
			gp.obj[15] = new Obj_Sofa(gp, 52, 6);
			gp.obj[16] = new Obj_Shelf(gp, 57, 4);
			gp.obj[17] = new Obj_Shelf(gp, 55, 4);
			gp.obj[18] = new Obj_Cabinet(gp, 60, 6);
			gp.obj[19] = new Obj_Door(gp, 66, 4);
			gp.obj[20] = new Obj_Sofa(gp, 70, 6);
			gp.obj[22] = new Obj_Sofa(gp, 72, 6);
			gp.obj[23] = new Obj_Cabinet(gp, 76, 6);
			gp.obj[24] = new Obj_Shelf(gp, 79, 4);
			gp.obj[25] = new Obj_Door(gp, 82, 4);
			gp.obj[26] = new Obj_Cabinet(gp, 87, 6);
			gp.obj[27] = new Obj_Shelf(gp, 92, 4);
			gp.obj[28] = new Obj_Shelf(gp, 90, 4);
			gp.obj[29] = new Obj_Shelf(gp, 96, 4);
			gp.obj[30] = new Obj_Door(gp, 100, 4);
			gp.obj[31] = new Obj_Cabinet(gp, 103, 6);
			gp.obj[32] = new Obj_Cabinet(gp, 105, 6);
			gp.obj[33] = new Obj_Sofa(gp, 108, 6);
			gp.obj[34] = new Obj_Sofa(gp, 110, 6);
			gp.obj[35] = new Obj_Cabinet(gp, 112, 6);
			gp.obj[36] = new Obj_Door(gp, 115, 4);
			gp.obj[37] = new Obj_Shelf(gp, 119, 4);
			gp.obj[38] = new Obj_Cabinet(gp, 122, 6);
			gp.obj[39] = new Obj_Sofa(gp, 124, 6);
			gp.obj[40] = new Obj_Door(gp, 134, 4);
			gp.obj[41] = new Obj_Cabinet(gp, 137, 6);
			gp.obj[42] = new Obj_Shelf(gp, 139, 4);
			gp.obj[43] = new Obj_Sofa(gp, 146, 6);
			gp.obj[44] = new Obj_Cabinet(gp, 149, 6);
			gp.obj[45] = new Obj_Shelf(gp, 151, 4);
			gp.obj[46] = new Obj_Sofa(gp, 154, 6);
			gp.obj[47] = new Obj_Door(gp, 156, 4);
			gp.obj[48] = new Obj_Exit(gp, 158, 6);
			gp.obj[49] = new Obj_Exit(gp, 158, 7);
			break;
		}
		
	}
	
	public void setNPC() {}
	
	public void setMonster() {
		
		switch(gp.stage) {
		case 1:
			break;
		case 2:
			gp.monster[0] = new Mon_Milky(gp);
			gp.monster[0].worldX = 27*gp.tileSize;
			gp.monster[0].worldY = 7*gp.tileSize;

			gp.monster[1] = new Mon_Milky(gp);
			gp.monster[1].worldX = 78*gp.tileSize;
			gp.monster[1].worldY = 7*gp.tileSize;

			gp.monster[2] = new Mon_Milky(gp);
			gp.monster[2].worldX = 85*gp.tileSize;
			gp.monster[2].worldY = 7*gp.tileSize;

			gp.monster[3] = new Mon_Garfield(gp);
			gp.monster[3].worldX = 105*gp.tileSize;
			gp.monster[3].worldY = 6*gp.tileSize;

			gp.monster[4] = new Mon_Milky(gp);
			gp.monster[4].worldX = 125*gp.tileSize;
			gp.monster[4].worldY = 7*gp.tileSize;

			gp.monster[5] = new Mon_Garfield(gp);
			gp.monster[5].worldX = 135*gp.tileSize;
			gp.monster[5].worldY = 7*gp.tileSize;
			
			break;
		case 3:
			gp.monster[0] = new Mon_Hawk(gp);
			gp.monster[0].worldX = 37*gp.tileSize;
			gp.monster[0].worldY = 3*gp.tileSize;
			
			break;
		case 4:
			gp.monster[0] = new Mon_Milky(gp);
			gp.monster[0].worldX = 11*gp.tileSize;
			gp.monster[0].worldY = 7*gp.tileSize;

			gp.monster[1] = new Mon_Milky(gp);
			gp.monster[1].worldX = 31*gp.tileSize;
			gp.monster[1].worldY = 7*gp.tileSize;

			gp.monster[2] = new Mon_Milky(gp);
			gp.monster[2].worldX = 22*gp.tileSize;
			gp.monster[2].worldY = 7*gp.tileSize;

			gp.monster[3] = new Mon_Milky(gp);
			gp.monster[3].worldX = 41*gp.tileSize;
			gp.monster[3].worldY = 7*gp.tileSize;

			gp.monster[4] = new Mon_Garfield(gp);
			gp.monster[4].worldX = 47*gp.tileSize;
			gp.monster[4].worldY = 7*gp.tileSize;

			gp.monster[5] = new Mon_Garfield(gp);
			gp.monster[5].worldX = 53*gp.tileSize;
			gp.monster[5].worldY = 7*gp.tileSize;

			gp.monster[6] = new Mon_Garfield(gp);
			gp.monster[6].worldX = 60*gp.tileSize;
			gp.monster[6].worldY = 7*gp.tileSize;

			gp.monster[7] = new Mon_Garfield(gp);
			gp.monster[7].worldX = 67*gp.tileSize;
			gp.monster[7].worldY = 7*gp.tileSize;

			gp.monster[8] = new Mon_Garfield(gp);
			gp.monster[8].worldX = 65*gp.tileSize;
			gp.monster[8].worldY = 7*gp.tileSize;

			gp.monster[9] = new Mon_Milky(gp);
			gp.monster[9].worldX = 81*gp.tileSize;
			gp.monster[9].worldY = 7*gp.tileSize;

			gp.monster[10] = new Mon_Milky(gp);
			gp.monster[10].worldX = 83*gp.tileSize;
			gp.monster[10].worldY = 7*gp.tileSize;

			gp.monster[11] = new Mon_Garfield(gp);
			gp.monster[11].worldX = 91*gp.tileSize;
			gp.monster[11].worldY = 7*gp.tileSize;

			gp.monster[12] = new Mon_Garfield(gp);
			gp.monster[12].worldX = 115*gp.tileSize;
			gp.monster[12].worldY = 7*gp.tileSize;

			gp.monster[13] = new Mon_Garfield(gp);
			gp.monster[13].worldX = 116*gp.tileSize;
			gp.monster[13].worldY = 7*gp.tileSize;

			gp.monster[14] = new Mon_Garfield(gp);
			gp.monster[14].worldX = 114*gp.tileSize;
			gp.monster[14].worldY = 7*gp.tileSize;

			gp.monster[15] = new Mon_Milky(gp);
			gp.monster[15].worldX = 131*gp.tileSize;
			gp.monster[15].worldY = 7*gp.tileSize;

			gp.monster[16] = new Mon_Milky(gp);
			gp.monster[16].worldX = 133*gp.tileSize;
			gp.monster[16].worldY = 7*gp.tileSize;

			gp.monster[17] = new Mon_Garfield(gp);
			gp.monster[17].worldX = 139*gp.tileSize;
			gp.monster[17].worldY = 7*gp.tileSize;

			gp.monster[18] = new Mon_Garfield(gp);
			gp.monster[18].worldX = 141*gp.tileSize;
			gp.monster[18].worldY = 7*gp.tileSize;

			gp.monster[19] = new Mon_Garfield(gp);
			gp.monster[19].worldX = 143*gp.tileSize;
			gp.monster[19].worldY = 7*gp.tileSize;

			gp.monster[20] = new Mon_Garfield(gp);
			gp.monster[20].worldX = 149*gp.tileSize;
			gp.monster[20].worldY = 7*gp.tileSize;
			
			break;
		case 5:
			gp.monster[0] = new Mon_Hawk(gp);
			gp.monster[0].worldX = 20*gp.tileSize;
			gp.monster[0].worldY = 3*gp.tileSize;

			gp.monster[1] = new Mon_Hawk(gp);
			gp.monster[1].worldX = 40*gp.tileSize;
			gp.monster[1].worldY = 6*gp.tileSize;

			gp.monster[2] = new Mon_Hawk(gp);
			gp.monster[2].worldX = 60*gp.tileSize;
			gp.monster[2].worldY = 4*gp.tileSize;

			gp.monster[3] = new Mon_Hawk(gp);
			gp.monster[3].worldX = 80*gp.tileSize;
			gp.monster[3].worldY = 2*gp.tileSize;

			gp.monster[4] = new Mon_Hawk(gp);
			gp.monster[4].worldX = 100*gp.tileSize;
			gp.monster[4].worldY = 1*gp.tileSize;

			gp.monster[5] = new Mon_Hawk(gp);
			gp.monster[5].worldX = 120*gp.tileSize;
			gp.monster[5].worldY = 7*gp.tileSize;

			gp.monster[6] = new Mon_Hawk(gp);
			gp.monster[6].worldX = 140*gp.tileSize;
			gp.monster[6].worldY = 4*gp.tileSize;

			gp.monster[7] = new Mon_Hawk(gp);
			gp.monster[7].worldX = 10*gp.tileSize;
			gp.monster[7].worldY = 4*gp.tileSize;

			gp.monster[8] = new Mon_Hawk(gp);
			gp.monster[8].worldX = 30*gp.tileSize;
			gp.monster[8].worldY = 4*gp.tileSize;

			gp.monster[9] = new Mon_Hawk(gp);
			gp.monster[9].worldX = 50*gp.tileSize;
			gp.monster[9].worldY = 4*gp.tileSize;

			gp.monster[10] = new Mon_Hawk(gp);
			gp.monster[10].worldX = 70*gp.tileSize;
			gp.monster[10].worldY = 4*gp.tileSize;

			gp.monster[11] = new Mon_Hawk(gp);
			gp.monster[11].worldX = 90*gp.tileSize;
			gp.monster[11].worldY = 4*gp.tileSize;

			gp.monster[12] = new Mon_Hawk(gp);
			gp.monster[12].worldX = 110*gp.tileSize;
			gp.monster[12].worldY = 4*gp.tileSize;

			gp.monster[13] = new Mon_Hawk(gp);
			gp.monster[13].worldX = 130*gp.tileSize;
			gp.monster[13].worldY = 4*gp.tileSize;

			gp.monster[14] = new Mon_Hawk(gp);
			gp.monster[14].worldX = 150*gp.tileSize;
			gp.monster[14].worldY = 4*gp.tileSize;
			break;
		case 6:
			gp.monster[0] = new Mon_Milky(gp);
			gp.monster[0].worldX = 11*gp.tileSize;
			gp.monster[0].worldY = 7*gp.tileSize;

			gp.monster[1] = new Mon_Milky(gp);
			gp.monster[1].worldX = 31*gp.tileSize;
			gp.monster[1].worldY = 7*gp.tileSize;

			gp.monster[2] = new Mon_Milky(gp);
			gp.monster[2].worldX = 22*gp.tileSize;
			gp.monster[2].worldY = 7*gp.tileSize;

			gp.monster[3] = new Mon_Milky(gp);
			gp.monster[3].worldX = 41*gp.tileSize;
			gp.monster[3].worldY = 7*gp.tileSize;

			gp.monster[4] = new Mon_Garfield(gp);
			gp.monster[4].worldX = 47*gp.tileSize;
			gp.monster[4].worldY = 7*gp.tileSize;

			gp.monster[5] = new Mon_Garfield(gp);
			gp.monster[5].worldX = 53*gp.tileSize;
			gp.monster[5].worldY = 7*gp.tileSize;

			gp.monster[6] = new Mon_Garfield(gp);
			gp.monster[6].worldX = 60*gp.tileSize;
			gp.monster[6].worldY = 7*gp.tileSize;

			gp.monster[7] = new Mon_Garfield(gp);
			gp.monster[7].worldX = 67*gp.tileSize;
			gp.monster[7].worldY = 7*gp.tileSize;

			gp.monster[8] = new Mon_Garfield(gp);
			gp.monster[8].worldX = 65*gp.tileSize;
			gp.monster[8].worldY = 7*gp.tileSize;

			gp.monster[9] = new Mon_Milky(gp);
			gp.monster[9].worldX = 81*gp.tileSize;
			gp.monster[9].worldY = 7*gp.tileSize;

			gp.monster[10] = new Mon_Milky(gp);
			gp.monster[10].worldX = 83*gp.tileSize;
			gp.monster[10].worldY = 7*gp.tileSize;

			gp.monster[11] = new Mon_Garfield(gp);
			gp.monster[11].worldX = 91*gp.tileSize;
			gp.monster[11].worldY = 7*gp.tileSize;

			gp.monster[12] = new Mon_Garfield(gp);
			gp.monster[12].worldX = 115*gp.tileSize;
			gp.monster[12].worldY = 7*gp.tileSize;

			gp.monster[13] = new Mon_Garfield(gp);
			gp.monster[13].worldX = 116*gp.tileSize;
			gp.monster[13].worldY = 7*gp.tileSize;

			gp.monster[14] = new Mon_Garfield(gp);
			gp.monster[14].worldX = 114*gp.tileSize;
			gp.monster[14].worldY = 7*gp.tileSize;

			gp.monster[15] = new Mon_Milky(gp);
			gp.monster[15].worldX = 131*gp.tileSize;
			gp.monster[15].worldY = 7*gp.tileSize;

			gp.monster[16] = new Mon_Milky(gp);
			gp.monster[16].worldX = 133*gp.tileSize;
			gp.monster[16].worldY = 7*gp.tileSize;

			gp.monster[17] = new Mon_Garfield(gp);
			gp.monster[17].worldX = 139*gp.tileSize;
			gp.monster[17].worldY = 7*gp.tileSize;

			gp.monster[18] = new Mon_Garfield(gp);
			gp.monster[18].worldX = 141*gp.tileSize;
			gp.monster[18].worldY = 7*gp.tileSize;

			gp.monster[19] = new Mon_Garfield(gp);
			gp.monster[19].worldX = 143*gp.tileSize;
			gp.monster[19].worldY = 7*gp.tileSize;

			gp.monster[20] = new Mon_Garfield(gp);
			gp.monster[20].worldX = 149*gp.tileSize;
			gp.monster[20].worldY = 7*gp.tileSize;
			break;
		case 7:
			
			gp.monster[0] = new Mon_Human(gp);
			gp.monster[0].worldX = 20*gp.tileSize;
			gp.monster[0].worldY = 3*gp.tileSize;
			
			gp.monster[1] = new Mon_Human(gp);
			gp.monster[1].worldX = 40*gp.tileSize;
			gp.monster[1].worldY = 3*gp.tileSize;
			
			gp.monster[2] = new Mon_Human(gp);
			gp.monster[2].worldX = 60*gp.tileSize;
			gp.monster[2].worldY = 3*gp.tileSize;
			
			gp.monster[3] = new Mon_Human(gp);
			gp.monster[3].worldX = 80*gp.tileSize;
			gp.monster[3].worldY = 3*gp.tileSize;
			
			gp.monster[4] = new Mon_Human(gp);
			gp.monster[4].worldX = 100*gp.tileSize;
			gp.monster[4].worldY = 3*gp.tileSize;
			
			gp.monster[5] = new Mon_Human(gp);
			gp.monster[5].worldX = 120*gp.tileSize;
			gp.monster[5].worldY = 3*gp.tileSize;
			
			gp.monster[6] = new Mon_Human(gp);
			gp.monster[6].worldX = 140*gp.tileSize;
			gp.monster[6].worldY = 3*gp.tileSize;
			
			break;
		}
		
		
	}

}
