package engine.Graphics;

import org.lwjgl.opengl.GL20;

public class Attribute {
	public Shader shader;
	public Attribute(Shader s) {
		shader = s;
	}
	public int getLocation(String name) {
		return GL20.glGetAttribLocation(shader.getID(), name);
	}
	public void setLocation(String name, int location) {
		GL20.glBindAttribLocation(shader.getID(), location, name);
		GL20.glLinkProgram(shader.getID());
	}
}