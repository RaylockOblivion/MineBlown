package com.raylock.entity.mob;

import com.raylock.entity.Entity;
import com.raylock.graphics.Sprite;

public class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if(xa!=0&&ya!=0){
            move(xa,0);
            move(0,ya);
            return;
        }
        
        if (xa > 0)dir = 1;
        if (xa < 0)dir = 3;
        if (ya > 0)dir = 2;
        if (ya < 0)dir = 0;
        if (!collision(xa,ya)) {
            x += xa;
            y += ya;
        }
    }

    public void update() {

    }

    public void render() {

    }

    private boolean collision(int xa,int ya) {
        boolean solid=false;
        for(int c=0;c<4;c++){
            int xt=((x+xa)+(c%2*1-16))/16;//00 10 01 11
            System.out.println("C: "+c+" X:"+xt);
            int yt=((y+ya)+(c/2*32-0))/16;
            solid = level.getTile(xt,yt).solid();
        }
        return solid;
    }
}
