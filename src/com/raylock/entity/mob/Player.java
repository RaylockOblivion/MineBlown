package com.raylock.entity.mob;

import com.raylock.graphics.Screen;
import com.raylock.graphics.Sprite;
import com.raylock.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite= Sprite.ant;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update() {
        int xa = 0, ya = 0;
        anim=anim<81?anim+1:0;
        if(input.up)ya--;
        if(input.down)ya++;
        if(input.left)xa--;
        if(input.right)xa++;

        if(xa != 0 || ya != 0){
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        if(walking){
            if(anim % 80 == 0)sprite = Sprite.ant7;
            else if(anim % 70 == 0)sprite = Sprite.ant6;
            else if(anim % 60 == 0)sprite = Sprite.ant5;
            else if(anim % 50 == 0)sprite = Sprite.ant4;
            else if(anim % 40 == 0)sprite = Sprite.ant3;
            else if(anim % 30 == 0)sprite = Sprite.ant2;
            else if(anim % 20 == 0)sprite = Sprite.ant1;
            else if(anim %10==0)sprite = Sprite.ant;
        }
        else if(anim %10==0)sprite=Sprite.ant;
        screen.renderPlayer(x - 16, y - 16, sprite, dir);
        }
    }
