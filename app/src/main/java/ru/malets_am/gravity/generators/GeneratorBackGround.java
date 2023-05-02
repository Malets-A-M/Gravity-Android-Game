package ru.malets_am.gravity.generators;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import ru.malets_am.gravity.objects.Star;
import ru.malets_am.my_framework.GraphicsFW;

public class GeneratorBackGround {
    public List<Star> starArrayList = new ArrayList<>();

    public GeneratorBackGround(int starsSpeak, int sceneWidth, int sceneHeight){
        for (int i = 0; i < starsSpeak; i++) {
            starArrayList.add(new Star(sceneWidth, sceneHeight));
        }
    }

    public void update(double speed){
        for (int i = 0; i < starArrayList.size(); i++) {
            starArrayList.get(i).update(speed);
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < starArrayList.size(); i++) {
            graphicsFW.drawPixel(starArrayList.get(i).getX(), starArrayList.get(i).getY(), Color.WHITE);
        }
    }
}
