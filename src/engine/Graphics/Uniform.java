package engine.Graphics;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import engine.Graphics.Shader;

import java.nio.FloatBuffer;

import org.joml.*;

public class Uniform {
	public Shader shader;
	public Uniform(Shader s) {
		shader = s;
	}
	public int getUniformLocation(String name) {
		shader.bind();
		return GL20.glGetUniformLocation(shader.getID(), name);
	}
	public void setInt1(String name, int v1) {
		GL20.glUniform1i(getUniformLocation(name), v1);
	}
	public void setSampler2D(String name, Texture texture) {
		GL20.glUniform1i(getUniformLocation(name), texture.getTextureUnit());
	}
	public void setInt2(String name, int v1, int v2) {
		GL20.glUniform2i(getUniformLocation(name), v1, v2);
	}
	public void setInt2(String name, Vector2ic v) {
		GL20.glUniform2i(getUniformLocation(name), v.x(), v.y());
	}
	public void setInt3(String name, int v1, int v2, int v3) {
		GL20.glUniform3i(getUniformLocation(name), v1, v2, v3);
	}
	public void setInt3(String name, Vector3ic v) {
		GL20.glUniform3i(getUniformLocation(name), v.x(), v.y(), v.z());
	}
	public void setInt4(String name, int v1, int v2, int v3, int v4) {
		GL20.glUniform4i(getUniformLocation(name), v1, v2, v3, v4);
	}
	public void setInt4(String name, Vector4ic v) {
		GL20.glUniform4i(getUniformLocation(name), v.x(), v.y(), v.z(), v.w());
	}
	public void setInt1List(String name, int[] v) {
		GL20.glUniform1iv(getUniformLocation(name), v);
	}
	public void setInt2List(String name, int[] v) {
		GL20.glUniform2iv(getUniformLocation(name), v);
	}
	public void setInt2List(String name, Vector2ic[] v) {
		int[] numbers = new int[v.length * 2];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
		}
		GL20.glUniform2iv(getUniformLocation(name), numbers);
	}
	public void setInt3List(String name, int[] v) {
		GL20.glUniform3iv(getUniformLocation(name), v);
	}
	public void setInt3List(String name, Vector3ic[] v) {
		int[] numbers = new int[v.length * 3];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
			numbers[i + 2] = v[i].y();
		}
		GL20.glUniform3iv(getUniformLocation(name), numbers);
	}
	public void setInt4List(String name, int[] v) {
		GL20.glUniform4iv(getUniformLocation(name), v);
	}
	public void setInt4List(String name, Vector4ic[] v) {
		int[] numbers = new int[v.length * 4];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
			numbers[i + 2] = v[i].y();
			numbers[i + 3] = v[i].y();
		}
		GL20.glUniform3iv(getUniformLocation(name), numbers);
	}

	public void setFloat1(String name, float v1) {
		GL20.glUniform1f(getUniformLocation(name), v1);
	}
	public void setFloat2(String name, float v1, float v2) {
		GL20.glUniform2f(getUniformLocation(name), v1, v2);
	}
	public void setFloat2(String name, Vector2fc v) {
		GL20.glUniform2f(getUniformLocation(name), v.x(), v.y());
	}
	public void setFloat3(String name, float v1, float v2, float v3) {
		GL20.glUniform3f(getUniformLocation(name), v1, v2, v3);
	}
	public void setFloat3(String name, Vector3fc v) {
		GL20.glUniform3f(getUniformLocation(name), v.x(), v.y(), v.z());
	}
	public void setFloat4(String name, float v1, float v2, float v3, float v4) {
		GL20.glUniform4f(getUniformLocation(name), v1, v2, v3, v4);
	}
	public void setFloat4(String name, Vector4fc v) {
		GL20.glUniform4f(getUniformLocation(name), v.x(), v.y(), v.z(), v.w());
	}
	public void setFloat1List(String name, float[] v) {
		GL20.glUniform1fv(getUniformLocation(name), v);
	}
	public void setFloat2List(String name, float[] v) {
		GL20.glUniform2fv(getUniformLocation(name), v);
	}
	public void setFloat2List(String name, Vector2fc[] v) {
		float[] numbers = new float[v.length * 2];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
		}
		GL20.glUniform2fv(getUniformLocation(name), numbers);
	}
	public void setFloat3List(String name, float[] v) {
		GL20.glUniform3fv(getUniformLocation(name), v);
	}
	public void setFloat3List(String name, Vector3fc[] v) {
		float[] numbers = new float[v.length * 3];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
			numbers[i + 2] = v[i].y();
		}
		GL20.glUniform3fv(getUniformLocation(name), numbers);
	}
	public void setFloat4List(String name, float[] v) {
		GL20.glUniform4fv(getUniformLocation(name), v);
	}
	public void setFloat4List(String name, Vector4fc[] v) {
		float[] numbers = new float[v.length * 4];
		for (int i = 0; i < v.length; i++) {
			numbers[i] = v[i].x();
			numbers[i + 1] = v[i].y();
			numbers[i + 2] = v[i].y();
			numbers[i + 3] = v[i].y();
		}
		GL20.glUniform3fv(getUniformLocation(name), numbers);
	}
	public void setMatrix2(String name, float v1, float v2, float v3, float v4) {
		GL20.glUniformMatrix2fv(getUniformLocation(name), false, new float[]{v1, v2, v3, v4});
	}
	public void setMatrix2List(String name, float[] values) {
		GL20.glUniformMatrix2fv(getUniformLocation(name), false, values);
	}
	public void setMatrix2Transpose(String name, float v1, float v2, float v3, float v4) {
		GL20.glUniformMatrix2fv(getUniformLocation(name), true, new float[]{v1, v2, v3, v4});
	}
	public void setMatrix2ListTranspose(String name, float[] values) {
		GL20.glUniformMatrix2fv(getUniformLocation(name), true, values);
	}
	public void setMatrix3(String name, Matrix3fc mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(9); 
		mat.get(buf);
		GL20.glUniformMatrix3fv(getUniformLocation(name), false, buf);
	}
	public void setMatrix3List(String name, Matrix3fc[] mat) {
		float[] buf = new float[mat.length * 9]; 
		//mat.get(buf);
		for (int i = 0; i < mat.length * 9; i += 9) {
			mat[i].get(buf, i);
		}
		GL20.glUniformMatrix3fv(getUniformLocation(name), false, buf);
	}
	public void setMatrix3Transpose(String name, Matrix3fc mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(9); 
		mat.getTransposed(buf);
		GL20.glUniformMatrix3fv(getUniformLocation(name), false, buf);
	}
	public void setMatrix3ListTranspose(String name, Matrix3fc[] mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(mat.length * 9); 
		//mat.get(buf);
		for (int i = 0; i < mat.length * 9; i += 9) {
			mat[i].getTransposed(i, buf);
		}
		GL20.glUniformMatrix3fv(getUniformLocation(name), false, buf);
	}

	public void setMatrix4(String name, Matrix4fc mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(16);
		mat.get(buf);
		GL20.glUniformMatrix4fv(getUniformLocation(name), false, buf);
	}
	public void setMatrix4List(String name, Matrix4fc[] mat) {
		float[] buf = new float[mat.length * 16]; 
		//mat.get(buf);
		for (int i = 0; i < mat.length * 16; i += 16) {
			mat[i].get(buf, i);
		}
		GL20.glUniformMatrix4fv(getUniformLocation(name), false, buf);
	}
	public void setMatrix4Transpose(String name, Matrix4fc mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(16); 
		mat.getTransposed(buf);
		GL20.glUniformMatrix4fv(getUniformLocation(name), true, buf);
	}
	public void setMatrix4ListTranspose(String name, Matrix4fc[] mat) {
		FloatBuffer buf = BufferUtils.createFloatBuffer(mat.length * 16); 
		//mat.get(buf);
		for (int i = 0; i < mat.length * 16; i += 16) {
			mat[i].getTransposed(i, buf);
		}
		GL20.glUniformMatrix4fv(getUniformLocation(name), true, buf);
	}
}