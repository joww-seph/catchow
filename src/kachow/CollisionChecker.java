package kachow;

import entity.Entity;

public class CollisionChecker {
    
    GamePanel gp;
	boolean landedOnObject = false;
	boolean landedOnEntity = false;
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity) {
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;
        
        int tileNum1, tileNum2, tileNum3, tileNum4;

        entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
    	tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
    	tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        
        if (entity.worldY >= gp.screenHeight - (gp.tileSize/2)) {
	        entity.worldY = gp.screenHeight - (gp.tileSize/2);
	        entity.isOnGround = true;
	        entity.isFalling = false;
	        entity.isJumping = false;
	    }

        if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
            entity.isOnGround = true;
            if (entity.isJumping) entity.spriteNum = 1;
            
            entity.worldY = entityBottomRow * gp.tileSize - entity.solidArea.height - entity.solidArea.y;
            entity.yVelocity = 0;
        } else {
        	if (!landedOnObject) entity.isOnGround = false;
        }
        
        entity.collisionOn = false;
        
        if (entity.direction.contains("left")) {
        	entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
        	tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        	if (gp.tileM.tile[tileNum4].collision) {
        		entity.collisionOn = true;
        	}
        }
    
        if (entity.direction.contains("right")) {
        	entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
        	tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        	if (gp.tileM.tile[tileNum3].collision) {
        		entity.collisionOn = true;
        	}
        }
    }
    
    public int checkObject(Entity entity, boolean player) {
    	
    	int index = 999;
    	
    	for (int i = 0; i < gp.obj.length; i++) {
    		
    		if (gp.obj[i] != null) {
    			
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			
    			gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
    			gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
    			
    			gp.obj[i].topArea.x = gp.obj[i].worldX + gp.obj[i].topArea.x;
    			gp.obj[i].topArea.y = gp.obj[i].worldY + gp.obj[i].topArea.y;
    			
    			if (entity.solidArea.intersects(gp.obj[i].topArea)) {
    				entity.isOnGround = true;
    				landedOnObject = true;
    	            if (entity.isJumping) entity.spriteNum = 1;
    	            
    	            entity.worldY = gp.obj[i].topArea.y - entity.solidArea.height - entity.solidArea.y + entity.worldY + gp.scale;
    	            
    	            entity.yVelocity = 0;
    	            if (player) index = i;
    			}
    			
    			if (!entity.solidArea.intersects(gp.obj[i].topArea) && landedOnObject) {
    				landedOnObject = false;
    			}

    			    			
    			if (entity.direction.contains("left")) {
    	        	entity.solidArea.x -= entity.speed;
    	        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    	        		if (gp.obj[i].collision) {
    	        			entity.collisionOn = true;
    	        		}
    	        		if (player) index = i;
    	        	}
    	        }
    			
    	        if (entity.direction.contains("right")) {
    	        	entity.solidArea.x += entity.speed;
    	        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    	        		if (gp.obj[i].collision) {
    	        			entity.collisionOn = true;
    	        		}
    	        		if (player) index = i;
    	        	}
    	        }
    	        
    	        entity.solidArea.x = entity.solidAreaDefaultX;
    	        entity.solidArea.y = entity.solidAreaDefaultY;
    	        gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
    	        gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
    	        
    	        gp.obj[i].topArea.x = gp.obj[i].topAreaDefaultX;
    	        gp.obj[i].topArea.y = gp.obj[i].topAreaDefaultY;
    			
    		}
    		
    	}
    	
    	if (!landedOnObject && !entity.isOnGround) {
            entity.isOnGround = false;
        }
    	
    	return index;
    	
    }
    
    public int checkEntity(Entity entity, Entity[] target) {
    	
    	int index = 999;
    	
    	for (int i = 0; i < target.length; i++) {
    		
    		if (target[i] != null) {
    			
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			
    			target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
    			target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
    			
    			target[i].topArea.x = target[i].worldX + target[i].topArea.x;
    			target[i].topArea.y = target[i].worldY + target[i].topArea.y;
    			
    			if (entity.solidArea.intersects(target[i].topArea)) {
    				entity.isOnGround = true;
    				landedOnEntity = true;
    	            if (entity.isJumping) entity.spriteNum = 1;
    	            
    	            entity.worldY = target[i].topArea.y - entity.solidArea.height - entity.solidArea.y + entity.worldY + gp.scale;
    	            
    	            entity.yVelocity = 0;
    	            index = i;
    			}
    			
    			if (!entity.solidArea.intersects(target[i].topArea) && landedOnEntity) {
    				landedOnEntity = false;
    			}
    			
    			if (entity.direction.contains("left")) {
    	        	entity.solidArea.x -= entity.speed;
    	        }
    			
    	        if (entity.direction.contains("right")) {
    	        	entity.solidArea.x += entity.speed;
    	        }
    	        

	        	if(entity.solidArea.intersects(target[i].solidArea)) {
	        		if (target[i] != entity) {
	        			index = i;
	        		}
	        		
	        	}
    	        
    	        entity.solidArea.x = entity.solidAreaDefaultX;
    	        entity.solidArea.y = entity.solidAreaDefaultY;
    	        target[i].solidArea.x = target[i].solidAreaDefaultX;
    	        target[i].solidArea.y = target[i].solidAreaDefaultY;
    	        
    	        target[i].topArea.x = target[i].topAreaDefaultX;
    	        target[i].topArea.y = target[i].topAreaDefaultY;
    			
    		}
    		
    	}
    	
    	if (!landedOnEntity && !entity.isOnGround) {
            entity.isOnGround = false;
        }
    	
    	return index;
    	
    }
    
    public boolean checkPlayer (Entity entity) {
    	
    	boolean contactPlayer = false;
    	
    	entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y = entity.worldY + entity.solidArea.y;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		gp.player.topArea.x = gp.player.worldX + gp.player.topArea.x;
		gp.player.topArea.y = gp.player.worldY + gp.player.topArea.y;
		
		if (entity.solidArea.intersects(gp.player.topArea)) {
			entity.isOnGround = true;
			landedOnEntity = true;
            if (entity.isJumping) entity.spriteNum = 1;
            
            entity.worldY = gp.player.topArea.y - entity.solidArea.height - entity.solidArea.y + entity.worldY + gp.scale;
            
            entity.yVelocity = 0;
		}
		
		if (!entity.solidArea.intersects(gp.player.topArea) && landedOnEntity) {
			landedOnEntity = false;
		}

		    			
		if (entity.direction.contains("left")) {
        	entity.solidArea.x -= entity.speed;
        }
		
        if (entity.direction.contains("right")) {
        	entity.solidArea.x += entity.speed;
        }

    	if(entity.solidArea.intersects(gp.player.solidArea)) {
    		contactPlayer = true;
    	}
        
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        
        gp.player.topArea.x = gp.player.topAreaDefaultX;
        gp.player.topArea.y = gp.player.topAreaDefaultY;
		
    	return contactPlayer;
    }
}

