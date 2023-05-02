package ru.malets_am.gravity;

import android.os.Bundle;

import ru.malets_am.gravity.scenes.MainMenuScene;
import ru.malets_am.my_framework.CoreFW;
import ru.malets_am.my_framework.LoopFW;
import ru.malets_am.my_framework.SceneFW;

public class Main extends CoreFW {
    public SceneFW getStartScene(){
        return new MainMenuScene(this);
    }
}