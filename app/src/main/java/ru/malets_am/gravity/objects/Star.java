package ru.malets_am.gravity.objects;

import ru.malets_am.my_framework.ObjectFW;
import ru.malets_am.my_framework.utilits.UtilRandomFW;

public class Star extends ObjectFW {
    public Star(int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = 0;
        this.speed = 2;
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
    }

    public void update(double speedPlayer) {
        x -= speedPlayer;
        x -= speed;
        if (x < 0){
            x = maxScreenX;
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }
    }
}
