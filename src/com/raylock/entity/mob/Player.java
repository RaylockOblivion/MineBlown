package com.raylock.entity.mob;

import com.raylock.graphics.Screen;
import com.raylock.graphics.Sprite;
import com.raylock.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
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
        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }
        if (input.up) {
            ya--;
        }
        if (input.down) {
            ya++;
        }
        if (input.left) {
            xa--;
        }
        if (input.right) {
            xa++;
        }

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        sprite = Sprite.playerD;
        switch (dir) {
            case 0:
                sprite = Sprite.playerU;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.playerU1;
                    } else {
                        sprite = Sprite.playerU2;
                    }
                }
                break;
            case 1:
                sprite = Sprite.playerR;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.playerR1;
                    } else {
                        sprite = Sprite.playerR2;
                    }
                }
                break;
            case 3:
                sprite = Sprite.playerL;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.playerL1;
                    } else {
                        sprite = Sprite.playerL2;
                    }
                }
                break;
            case 2:
                sprite = Sprite.playerD;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.playerD1;
                    } else {
                        sprite = Sprite.playerD2;
                    }
                }
                break;
        }
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
