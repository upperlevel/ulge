package xyz.upperlevel.ulge.gui.impl;

import org.joml.Matrix4f;
import xyz.upperlevel.ulge.gui.GuiRenderer;

public class GuiButton extends GuiPane {

    public GuiButton() {
    }

    @Override
    public void render(Matrix4f transformation, GuiRenderer renderer) {
        super.render(transformation, renderer);

        // todo render text
    }
}