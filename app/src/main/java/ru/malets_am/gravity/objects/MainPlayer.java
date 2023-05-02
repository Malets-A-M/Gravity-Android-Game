package ru.malets_am.gravity.objects;

import ru.malets_am.my_framework.AnimationFW;
import ru.malets_am.my_framework.CoreFW;
import ru.malets_am.my_framework.GraphicsFW;
import ru.malets_am.my_framework.ObjectFW;
import ru.malets_am.gravity.utilits.UtilResource;

public class MainPlayer extends ObjectFW {
    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationFW animMainPlayer;
    AnimationFW animMainPlayerBoost;
    CoreFW coreFW;

    boolean boosting;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 200;
        speed = 1;
        boosting = false;
        this.coreFW = coreFW;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animMainPlayer = new AnimationFW(
                1,
                UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3)
        );
        animMainPlayerBoost = new AnimationFW(
                1,
                UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1),
                UtilResource.spritePlayerBoost.get(2),
                UtilResource.spritePlayerBoost.get(3)
        );

    }

    public void update() {
        if (coreFW.getTouchListenerFW().getTouchDown(0, maxScreenY, maxScreenX, maxScreenY)) {
            startBoosting();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
            stopBoosting();
        }

        if (boosting) {
            speed += 0.1;
        } else speed -= 3;
        if (speed > MAX_SPEED) speed = MAX_SPEED;
        if (speed < MIN_SPEED) speed = MIN_SPEED;

        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenY) {
            y = maxScreenY;
        }
        if (boosting) {
            animMainPlayerBoost.runAnimation();
        } else animMainPlayer.runAnimation();
    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW) {
        if (boosting == true) {
            animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
        } else animMainPlayer.drawingAnimation(graphicsFW, x, y);
    }
}
