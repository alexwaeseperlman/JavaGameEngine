package engine.Graphics;

import org.lwjgl.opengl.*;

import engine.Engine.Cleanable;

public class VAO implements Cleanable {
	private VBO[] vbos;
	public final int id;

	public VAO(VBO... vboList) {
		vbos = vboList;
		id = GL30.glGenVertexArrays();
		bind();
		for (int i = 0; i < vbos.length; i++) {
			vbos[i].bind();
			GL20.glVertexAttribPointer(i, vbos[i].vertexSize, GL11.GL_FLOAT, vbos[i].normalized, 0, 0);
			GL20.glEnableVertexAttribArray(i);
			System.out.printf("Enabling %d\n", i);
		}
	}

	public void cleanUp() {
		GL30.glDeleteVertexArrays(id);
	}

	public void bind() {
		GL30.glBindVertexArray(id);
	}

	public void draw(Renderer.drawModes drawMode, int begin, int end) {
		bind();
		GL11.glDrawArrays(drawMode.mode, begin, end);
	}
}