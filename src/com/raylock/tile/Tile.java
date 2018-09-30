package com.raylock.tile;

import com.raylock.graphics.Screen;
import com.raylock.graphics.Sprite;

public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile dirt = new DirtTile(Sprite.dirt);
    public static Tile dirt1 = new DirtTile(Sprite.dirt1);
    public static Tile voidTile = new voidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}
