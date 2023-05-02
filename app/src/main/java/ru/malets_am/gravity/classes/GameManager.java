package ru.malets_am.gravity.classes;

import ru.malets_am.gravity.generators.GeneratorBackGround;
import ru.malets_am.gravity.objects.MainPlayer;
import ru.malets_am.my_framework.CoreFW;
import ru.malets_am.my_framework.GraphicsFW;

public class GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    MainPlayer mainPlayer;
    GeneratorBackGround generatorBackGround;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight){
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenX = 0;
        minScreenY = 0;
        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY, minScreenY);
        generatorBackGround = new GeneratorBackGround(50, sceneWidth, sceneHeight);
    }

    public void update(){
        mainPlayer.update();
        generatorBackGround.update(mainPlayer.getSpeed());
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        generatorBackGround.drawing(graphicsFW);
    }
}
