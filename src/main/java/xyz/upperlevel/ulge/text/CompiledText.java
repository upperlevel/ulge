package xyz.upperlevel.ulge.text;

import org.joml.Vector2f;

public abstract class CompiledText<R extends TextRenderer> {
    public final SuperText text;
    public final Vector2f size;
    private final R renderer;

    public CompiledText(SuperText text, R renderer, Vector2f size) {
        this.text = text;
        this.renderer = renderer;
        this.size = size;
    }

    public abstract void render(Vector2f pos, TextRenderer.TextOrigin origin, float distance);
}