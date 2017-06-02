package engine.Graphics;

import java.util.Arrays;

import org.lwjgl.opengl.*;
import com.google.common.primitives.*;

import engine.Engine.Disposable;

public class VBO implements Disposable {
	private float[] dataArray;
	public final int id;
	public final int vertexSize;
	public boolean normalized = false;
	public final int access;

	public static class types {
		public static enum frequency {
			STREAM, STATIC, DYNAMIC
		}

		public static enum access {
			DRAW, COPY, READ
		}
	}

	public VBO(float[] obj, types.frequency frequency, types.access accessType, int vertSize) {
		access = getReadFrequencyType(frequency, accessType);
		dataArray = obj;
		vertexSize = vertSize;

		id = GL15.glGenBuffers();
		updateData();
	}

	public VBO(float[][] obj, types.frequency frequency, types.access accessType) {
		this(Floats.concat(obj), frequency, accessType, obj[0].length);
	}

	public VBO(float[][] obj) {
		this(Floats.concat(obj), types.frequency.STATIC, types.access.DRAW, obj[0].length);
	}

	public void updateData(int access) {
		bind();
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, dataArray, access);
		System.out.println("Set data to " + Arrays.toString(dataArray));
	}

	public static int getReadFrequencyType(types.frequency frequency, types.access access) {
		int openglAccessType = GL15.GL_STATIC_READ;
		switch (frequency) {
		case STREAM:
			switch (access) {
			case DRAW:
				openglAccessType = GL15.GL_STREAM_DRAW;
				break;
			case COPY:
				openglAccessType = GL15.GL_STREAM_COPY;
				break;
			case READ:
				openglAccessType = GL15.GL_STREAM_READ;
				break;
			}
			break;
		case STATIC:
			switch (access) {
			case DRAW:
				openglAccessType = GL15.GL_STATIC_DRAW;
				break;
			case COPY:
				openglAccessType = GL15.GL_STATIC_COPY;
				break;
			case READ:
				openglAccessType = GL15.GL_STATIC_READ;
				break;
			}
			break;
		case DYNAMIC:
			switch (access) {
			case DRAW:
				openglAccessType = GL15.GL_DYNAMIC_DRAW;
				break;
			case COPY:
				openglAccessType = GL15.GL_DYNAMIC_COPY;
				break;
			case READ:
				openglAccessType = GL15.GL_DYNAMIC_READ;
				break;
			}
			break;
		}
		return openglAccessType;
	}

	public void updateData() {
		updateData(access);
	}

	public void dispose() {
		GL15.glDeleteBuffers(id);
	}

	public void bind() {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
	}
}