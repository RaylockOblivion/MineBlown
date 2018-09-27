package com.raylock.level;

import com.raylock.tile.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

    private int levelPixels[];

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new Tile[w * h];
            levelPixels = new int[w * h];
            image.getRGB(0, 0, w, h, levelPixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Level File couldn't load");
        }
    }

    protected void generateLevel() {
        for (int i = 0; i < levelPixels.length; i++) {
            if (levelPixels[i] == 0xff00ff00) {
                tiles[i] = Tile.grass;
            } else if (levelPixels[i] == 0xffffff00) {
                tiles[i] = Tile.flower;
            } else if (levelPixels[i] == 0xff7f7f00) {
                tiles[i] = Tile.rock;
            }
        }
    }
}
