package kachow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean up, down, left, right, jump, attack, dash, sit;
	
	public KeyHandler (GamePanel gp) {this.gp = gp;}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (gp.gameState == gp.titleState) {
			
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) gp.ui.commandNum = 2;
			}
			
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) gp.ui.commandNum = 0;
			}
			
			if (code == KeyEvent.VK_ENTER) {
				switch(gp.ui.commandNum) {
				case 0:
					gp.gameState = gp.cutsceneState;
					gp.ui.commandNum = 0;
					break;
				case 1: 
					gp.gameState = gp.playState;
					gp.player.life = 9;
					gp.saveLoad.load();
					gp.ui.commandNum = 0;
					break;
				case 2: System.exit(0); break;
				}
			}
			
		}
		
		if (gp.gameState == gp.playState ) {
			
			if (code == KeyEvent.VK_W) {
				up = true;
			}
			
			if (code == KeyEvent.VK_S) {
				down = true;
			}
			
			if (code == KeyEvent.VK_A) {
				left = true;
			}
			
			if (code == KeyEvent.VK_D) {
				right = true;
			}
			
			if (code == KeyEvent.VK_E) {
				attack = true;
			}
			
			if (code == KeyEvent.VK_SPACE) {
				jump = true;
			}
			
			if (code == KeyEvent.VK_SHIFT) {
				dash = true;
			}
			
			if (code == KeyEvent.VK_Q) {
				sit = true;
			}
			
			if (code == KeyEvent.VK_ESCAPE) {
				gp.gameState = gp.pauseState;
				gp.player.fasterTemp = System.currentTimeMillis() - gp.player.fasterStart;
				gp.player.dblJumpTemp = System.currentTimeMillis() - gp.player.dblJumpStart;
				gp.player.invisibleTemp = System.currentTimeMillis() - gp.player.invisibleStart;
				gp.player.airSlashTemp = System.currentTimeMillis() - gp.player.airSlashStart;
				gp.player.dashTemp = System.currentTimeMillis() - gp.player.dashStartTime;
			}
			
		} else if (gp.gameState == gp.pauseState) {
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if (gp.ui.commandNum < 0) gp.ui.commandNum = 2;
			}
			
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if (gp.ui.commandNum > 2) gp.ui.commandNum = 0;
			}
			
			if (code == KeyEvent.VK_ENTER) {
				switch(gp.ui.commandNum) {
				case 0:
					gp.gameState = gp.playState;
					gp.ui.commandNum = 0;
					break;
				case 1: 
					gp.gameState = gp.titleState;
					gp.stopMusic();
					gp.playMusic(0);
					gp.ui.commandNum = 0;
					break;
				case 2: System.exit(0); break;
				}
			}
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			up = false;
		}
		
		if (code == KeyEvent.VK_S) {
			down = false;
		}
		
		if (code == KeyEvent.VK_A) {
			left = false;
		}
		
		if (code == KeyEvent.VK_D) {
			right = false;
		}
		
		if (code == KeyEvent.VK_E) {
			attack = false;
		}
		
		if (code == KeyEvent.VK_SPACE) {
			jump = false;
		}
		
		if (code == KeyEvent.VK_SHIFT) {
			dash = false;
		}
		
		if (code == KeyEvent.VK_Q) {
			sit = false;
		}
		
	}

}
