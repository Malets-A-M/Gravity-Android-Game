package ru.malets_am.gravity.scenes;

import android.graphics.Color;

import ru.malets_am.gravity.R;
import ru.malets_am.gravity.classes.GameManager;
import ru.malets_am.gravity.generators.GeneratorBackGround;
import ru.malets_am.gravity.objects.Star;
import ru.malets_am.my_framework.CoreFW;
import ru.malets_am.my_framework.SceneFW;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAME_OVER
    }

    GameState gameState;
    GameManager gameManager;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        switch (gameState){
            case READY:
                updateStateReady();
                break;
            case RUNNING:
                updateStateRunning();
                break;
            case PAUSE:
                updateStatePause();
                break;
            case GAME_OVER:
                updateStateGameOver();
                break;

        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        switch (gameState){
            case READY:
                drawingStateReady();
                break;
            case RUNNING:
                drawingStateRunning();
                break;
            case PAUSE:
                drawingStatePause();
                break;
            case GAME_OVER:
                drawingStateGameOver();
                break;

        }
    }

    private void drawingStateGameOver() {
    }
    private void updateStateGameOver() {

    }

    private void drawingStatePause() {
    }
    private void updateStatePause() {
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        gameManager.drawing(coreFW, graphicsFW);
    }
    private void updateStateRunning() {
        gameManager.update();
    }

    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready),
                250, 300, Color.WHITE, 60, null);
    }
    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState = GameState.RUNNING;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
