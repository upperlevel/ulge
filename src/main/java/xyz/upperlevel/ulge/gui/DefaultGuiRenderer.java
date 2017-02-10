package xyz.upperlevel.ulge.gui;

import xyz.upperlevel.ulge.opengl.shader.*;
import xyz.upperlevel.ulge.opengl.texture.Texture2D;
import xyz.upperlevel.ulge.util.Color;

public class DefaultGuiRenderer extends GuiRenderer {

    public static final DefaultGuiRenderer $ = new DefaultGuiRenderer();

    private Uniform uBounds, uColor, uDepth;

    public DefaultGuiRenderer() {
        super(createProgram());

        Uniformer u = getProgram().uniformer;
        uBounds = checkUniform(u.get("bounds"), "bounds");
        uColor  = checkUniform(u.get("col")   , "col");
        uDepth  = checkUniform(u.get("depth") , "depth");
    }

    @Override
    public void setBounds(Bounds bounds) {
        uBounds.set(bounds.minX, bounds.minY, bounds.maxX, bounds.maxY);
    }

    @Override
    public void setColor(Color color) {
        uColor.set(color);
    }

    @Override
    public void setDepth(float depth) {
        uDepth.set(depth);
    }

    private static Program createProgram() {
        Program program = new Program();
        program.attach(Shader.create(ShaderType.VERTEX  , "gui/vertex_shader.glsl"  , DefaultGuiRenderer.class));
        program.attach(Shader.create(ShaderType.FRAGMENT, "gui/fragment_shader.glsl", DefaultGuiRenderer.class));
        program.link();
        return program;
    }

    private static Uniform checkUniform(Uniform u, String name) {
        if (u == null)
            throw new NullPointerException("Cannot find uniform \"" + name + "\" in the program!");
        return u;
    }

    public static DefaultGuiRenderer $() {
        return $;
    }
}
