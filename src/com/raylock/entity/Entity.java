package com.raylock.entity;

import com.raylock.graphics.Screen;
import com.raylock.level.Level;
import java.util.Random;

public class Entity {

    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update() {

    }

    public void render(Screen screen) {

    }

    public void remove() {
        //Remove from level
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
    
    public void init(Level level){
        this.level=level;
    }
}
