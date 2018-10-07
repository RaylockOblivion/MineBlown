package com.raylock.tile;

import com.raylock.graphics.Screen;
import com.raylock.graphics.Sprite;

public class RockTile extends Tile {

    public RockTile(Sprite rock) {
        super(rock);
    }

    public boolean solid() {
        return true;
    }
    
    public boolean breakable() {
        return true;
    }
    
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<7 , y<< 7, this);
    }
}
