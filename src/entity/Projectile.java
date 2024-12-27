package entity;

import kachow.GamePanel;

public class Projectile extends Entity {
	
	Entity user;

	public Projectile(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
	}
	
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		
		this.worldX = worldX;
		this.worldY = worldY;
		if(direction.contains("left")) this.direction = "left";
		if(direction.contains("right")) this.direction = "right";
		this.alive = alive;
		this.user = user;
		this.life = this.maxLife;
		
	}
	
	public void update() {
		
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		if (monsterIndex != 999) {
			gp.player.damageMonster(monsterIndex);
			alive = false;
		}
		
		switch (direction) {
		case "left": worldX -= speed; break;
		case "right": worldX += speed; break;
		}
		
		life--;
		alive = life > 0;
		
	}

}
