package engine.Graphics;

import java.io.IOException;

import org.lwjgl.opengl.*;

import engine.Engine.Cleanable;
import engine.Utils.*;
public class Shader implements Cleanable {
	public Uniform uniform;
	public Attribute attribute;
	private String source;
	private int vertexID;
	public int getVertexID() {
		return vertexID;
	}
	private int fragmentID;
	public int getFragmentID() {
		return fragmentID;
	}
	private int shaderID;
	public int getID() {
		return shaderID;
	}
	public String getSource() {
		return source;
	}
	public Shader(String vert, String frag) {
		uniform = new Uniform(this);
		attribute = new Attribute(this);
		vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);

		GL20.glShaderSource(vertexID, vert);
		GL20.glShaderSource(fragmentID, frag);

		GL20.glCompileShader(vertexID);
		GL20.glCompileShader(fragmentID);

		if (GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.println("Unable to compile vertex shader: ");
			System.err.println(GL20.glGetShaderInfoLog(vertexID));
		}

		if (GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.println("Unable to compile fragment shader: ");
			System.err.println(GL20.glGetShaderInfoLog(fragmentID));
		}

		shaderID = GL20.glCreateProgram();

		GL20.glAttachShader(shaderID, vertexID);
		GL20.glAttachShader(shaderID, fragmentID);
		
		GL20.glLinkProgram(shaderID);
	}

	public void cleanUp() {
		GL20.glDetachShader(shaderID, vertexID);
		GL20.glDetachShader(shaderID, fragmentID);
		GL20.glDeleteProgram(shaderID);
		GL20.glDeleteShader(vertexID);
		GL20.glDeleteShader(fragmentID);
	}

	public static Shader fromFile(String vert, String frag) {
		try {
			return new Shader(IO.loadFile(vert), IO.loadFile(frag));
		}
		catch (IOException exception) {
			System.err.println("Could not find file");
			return new Shader("", "");
		}
	}

	public void bind() {
		GL20.glUseProgram(shaderID);
	}

	public static Shader fromFile(String path) {
		return Shader.fromFile(path + ".vert", path + ".frag");
	}
}