package data;

import java.io.*;

import kachow.GamePanel;

public class SaveLoad {

    private static final String SAVE_FILE = "main.txt";
    private final GamePanel gp;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            int stageToSave = (gp.stage == 0) ? 1 : (gp.stage == 8) ? 7 : gp.stage;
            oos.writeInt(stageToSave);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save the game: " + e.getMessage());
        }
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            gp.stage = ois.readInt();
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load the game: " + e.getMessage());
        }
    }
}
