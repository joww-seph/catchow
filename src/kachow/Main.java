package kachow;
//
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame("CAT-chow");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		try {
            Image icon = ImageIO.read(Main.class.getResource("/icon.png"));
            f.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		GamePanel gp = new GamePanel();
		f.add(gp);
		
		f.pack();
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		gp.setupGame();
		
		gp.startGameThread();

	}

}
