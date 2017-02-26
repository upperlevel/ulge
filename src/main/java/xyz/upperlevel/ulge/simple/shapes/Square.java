package xyz.upperlevel.ulge.simple.shapes;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import xyz.upperlevel.ulge.opengl.DataType;
import xyz.upperlevel.ulge.opengl.buffer.*;
import xyz.upperlevel.ulge.opengl.shader.Uniform;
import xyz.upperlevel.ulge.opengl.shader.Uniformer;
import xyz.upperlevel.ulge.opengl.texture.Texture2D;
import xyz.upperlevel.ulge.simple.SimpleRenderable;
import xyz.upperlevel.ulge.util.Color;

import static org.lwjgl.opengl.GL11.*;

public class Square extends SimpleRenderable {

    public static final Vao vao;

    public static final float vertices[] = {
            //Coords (x, y, z)     //TexCoords
             0.0f,  0.0f,   0.0f, 1.0f,
             0.0f,  1.0f,   0.0f, 0.0f,
             1.0f,  0.0f,   1.0f, 1.0f,
             1.0f,  1.0f,   1.0f, 0.0f,
    };

    public static final int indices[] = {
            0, 1, 2,
            1, 2, 3,
    };

    static {
        vao = new Vao();
        vao.bind();
        {

            Ebo ebo = new Ebo();
            ebo.loadData(indices, EboDataUsage.STATIC_DRAW);

            Vbo vbo = new Vbo();
            vbo.bind();
            vbo.loadData(vertices, VboDataUsage.STATIC_DRAW);
            new VertexLinker(DataType.FLOAT)
                    .attrib(0, 2)
                    .attrib(1, 2)
                    .setup();
            vbo.unbind();
        }
        vao.unbind();
    }

    public Vector2f pos;
    public Vector2f size;

    public float rotation = 0f;

    protected Uniform uTransform;

    public Square(Vector2f pos, Vector2f size, Color color) {
        super(color);
        this.pos = pos;
        this.size = size;
    }

    public Square(Vector2f pos, Vector2f size, Texture2D texture) {
        super(texture);
        this.pos = pos;
        this.size = size;
    }

    public Matrix4f getTransform() {
        Matrix4f matrix = new Matrix4f();
        matrix.translate(pos.x, pos.y, 0);
        matrix.scale(size.x, size.y, 1);

        if (rotation != 0)
            matrix.rotate(rotation, 0f, 0f, 1f);
        return matrix;
    }

    @Override
    public void init(Uniformer uniformer) {
        super.init(uniformer);
        uTransform = uniformer.get("transform");
    }


    @Override
    public void draw(Uniformer uniformer) {
        super.draw(uniformer);

        uTransform.set(getTransform());

        vao.bind();
        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
        vao.unbind();
    }
}
