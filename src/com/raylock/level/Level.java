package com.raylock.level;

import com.raylock.graphics.Screen;
import com.raylock.tile.Tile;

public class Level {

    protected int width, height;
    protected int tilesInt[];
    protected int tiles[];
    private int anim=0;

    public static Level spawn = new SpawnLevel("/levels/spawn.png");

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
        anim=(anim<60)?anim+1:0;
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
        if(x < 0 || y < 0 || x >= width || y >= height)return Tile.voidTile;
        if(tiles[x + y * width] == Tile.col_grass)return Tile.grass;
        if(tiles[x + y * width] == Tile.col_water)return (anim<30)?Tile.water:Tile.water1;
        if(tiles[x + y * width] == Tile.col_stone)return Tile.stone;
        if(tiles[x + y * width] == Tile.col_stone1)return Tile.stone1;
        if(tiles[x + y * width] == Tile.col_gravel)return Tile.gravel;
        if(tiles[x + y * width] == Tile.col_peat)return Tile.peat;
        if(tiles[x + y * width] == Tile.col_peat1)return Tile.peat1;
        if(tiles[x + y * width] == Tile.col_silt)return Tile.silt;
        if(tiles[x + y * width] == Tile.col_silt1)return Tile.silt1;
        if(tiles[x + y * width] == Tile.col_clay)return Tile.clay;
        if(tiles[x + y * width] == Tile.col_clay1)return Tile.clay1;
        if(tiles[x + y * width] == Tile.col_sand)return Tile.sand;
        if(tiles[x + y * width] == Tile.col_sand1)return Tile.sand1;
        return Tile.voidTile;
    }

}
