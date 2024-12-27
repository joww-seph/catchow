package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import kachow.GamePanel;

public class SaveLoad {
	
	GamePanel gp;
	
	public SaveLoad(GamePanel gp) {
		this.gp = gp;
	}
	
	public void save() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("main.sav")))) {
			
			DataStorage ds = new DataStorage();
			
			if (gp.stage == 0) gp.stage = 1;
			if (gp.stage == 8) gp.stage = 7;
			
			ds.stage = gp.stage;
			
			oos.writeObject(ds);
			
		} catch (Exception e) {
			System.out.println("Save Exception!");
		}
	}
	
	public void load() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("main.sav")))) {
			
			DataStorage ds = (DataStorage)ois.readObject();
			
			gp.stage = ds.stage;
			
		} catch (Exception e) {
			System.out.println("Save Exception!");
		}
	}

}
