package com.raylock.tile;

import com.raylock.graphics.Screen;
import com.raylock.graphics.Sprite;

public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile water = new WaterTile(Sprite.water);
    public static Tile water1 = new WaterTile(Sprite.water1);
    public static Tile stone = new StoneTile(Sprite.stone);
    public static Tile stone1 = new StoneTile(Sprite.stone1);
    public static Tile gravel = new GravelTile(Sprite.gravel);
    public static Tile peat = new PeatTile(Sprite.peat);
    public static Tile peat1 = new PeatTile(Sprite.peat1);
    public static Tile silt = new SiltTile(Sprite.silt);
    public static Tile silt1 = new SiltTile(Sprite.silt1);
    public static Tile clay = new ClayTile(Sprite.clay);
    public static Tile clay1 = new ClayTile(Sprite.clay1);
    public static Tile sand = new SandTile(Sprite.sand);
    public static Tile sand1 = new SandTile(Sprite.sand1);
    
    public static Tile voidTile = new voidTile(Sprite.voidSprite);
    
    public static final int col_grass = 0xff7ad11c;
    public static final int col_water = 0xff0004ff;
    public static final int col_stone = 0xff8eb4ff;
    public static final int col_stone1 = 0xff5c77a5;
    public static final int col_gravel = 0xffa4a45d;
    public static final int col_peat = 0xffa33f1b;
    public static final int col_peat1 = 0xffa35032;
    public static final int col_silt = 0xffb28e5c;
    public static final int col_silt1 =0xff876b46;
    public static final int col_clay = 0xffff5f32;
    public static final int col_clay1 =0xffb74424;
    public static final int col_sand = 0xffdbb52b;
    public static final int col_sand1 = 0xffa08420;
    
    //public static Tile rocks = new RockTile(Sprite.rocks);
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}
