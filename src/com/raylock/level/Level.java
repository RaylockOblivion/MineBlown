package com.raylock.level;

import com.raylock.graphics.Screen;
import com.raylock.tile.Tile;

public class Level {

    protected int width, height;
    protected int tilesInt[];
    protected int tiles[];

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path) {

    }

    public void update() {

    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int y0 = yScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == 0xffd11c1c)return Tile.dirt1;
        if (tiles[x + y * width] == 0xffd1981c)return Tile.dirt;
        if (tiles[x + y * width] == 0xff7ad11c)return Tile.grass;
        if (tiles[x + y * width] == 0xffb21cd1)return Tile.stone;
        if (tiles[x + y * width] == 0xff1c1dd1)return Tile.stone1;
        if (tiles[x + y * width] == 0xff1ccdd1)return Tile.redDirt;
        if (tiles[x + y * width] == 0xffc18dcb)return Tile.redDirt1;
        if (tiles[x + y * width] == 0xff9191cb)return Tile.sand;
        if (tiles[x + y * width] == 0xffa4c8c7)return Tile.gravel;
        return Tile.voidTile;
    }

}
