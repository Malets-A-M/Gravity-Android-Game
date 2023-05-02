package ru.malets_am.my_framework;

import android.graphics.Bitmap;

public class AnimationFW {
    double speedAnimation;
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;
    Bitmap sprite1;
    Bitmap sprite2;
    Bitmap sprite3;
    Bitmap sprite4;

    public AnimationFW(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4) {
        this.speedAnimation = speedAnimation;
        sprite= sprite1;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        this.sprite4 = sprite4;
        frames = 4;
    }

    public void runAnimation(){
        delayIndex++;
        switch (countFrames){
            case 0:
                sprite = sprite1;
                break;
            case 1:
                sprite = sprite2;
                break;
            case 2:
                sprite = sprite3;
                break;
            case 3:
                sprite = sprite4;
                break;
        }
        countFrames++;
        if (countFrames > frames - 1){
            countFrames = 0;
        }
    }

    public void drawingAnimation(GraphicsFW graphicsFW, int x, int y){
        graphicsFW.drawTexture(sprite, x, y);
    }
}
