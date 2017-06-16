package xyz.upperlevel.ulge.game;

import xyz.upperlevel.ulge.window.event.action.Action;
import xyz.upperlevel.ulge.window.event.button.MouseButton;
import xyz.upperlevel.ulge.window.event.key.Key;

public class Stage implements Scene {

    private Scene scene = null;

    public Stage() {
    }

    public Stage(Scene start) {
        setScene(start);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        Scene old = this.scene;
        this.scene = scene;
        if (old != null)
            old.onDisable(scene);
        if (scene != null)
            scene.onEnable(old);
    }
    
    @Override
    public void onEnable(Scene previous) {
        if (scene != null)
            scene.onEnable(previous);
    }

    @Override
    public void onDisable(Scene next) {
        if (scene != null)
            scene.onDisable(next);
    }

    @Override
    public void onTick() {
        if (scene != null)
            scene.onTick();
    }

    @Override
    public void onFps() {
        if (scene != null)
            scene.onFps();
    }

    @Override
    public void onRender() {
        if (scene != null)
            scene.onRender();
    }
    
    @Override
    public void onMouseButtonChange(MouseButton button, Action action) {
        if (scene != null)
            scene.onMouseButtonChange(button, action);
    }

    @Override
    public void onKeyChange(Key key, Action action) {
        if (scene != null)
            scene.onKeyChange(key, action);
    }

    @Override
    public void onMouseScroll(double x, double y) {
        if (scene != null)
            scene.onMouseScroll(x, y);
    }

    @Override
    public void onCursorMove(double x, double y) {
        if (scene != null)
            scene.onCursorMove(x, y);
    }
}
