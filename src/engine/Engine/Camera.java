package engine.Engine;

import org.joml.*;
/*
public class Camera {

	public static Camera perspective(float width, float height, float fov, float near, float far) {
		Camera c = new Camera();
		c.projection.perspective(fov, width / height, near, far);
		return c;
	}

	public static Camera perspective(float width, float height, float fov) {
		return perspective(width, height, fov, 0.01f, 100f);
	}

	public static Camera ortho(float width, float height, float near, float far) {
		Camera c = new Camera();
		c.projection.ortho(0, width, near, 0, near, far);
		return c;
	}

	public Matrix4f projection = new Matrix4f();
	public Matrix4f view = new Matrix4f();
	private Matrix4f projectionView = new Matrix4f();
	private float width;

	public float getWidth() {
		return this.width;
	}

	public void setWidth(float width) {
		this.width = width;
		this.view.scale(1 / width, 1 / this.height, 1);
	}

	private float height;

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
		this.view.scale(1 / this.width, 1 / height, 1);
	}

	public Matrix4fc getMatrix() {
		view.mul(projection, projectionView);
		return projectionView;
	}

	public void translate(float x, float y, float z) {
		view.translate(x, y, z);
	}

	public void translate(Vector3fc position) {
		view.translate(position);
	}

	public void translate(float x, float y) {
		view.translate(x, y, 0);
	}

	public void translate(Vector2f position);

	public void rotate(float z);

	public void rotate(Vector3f rot);

	public void rotate(float x, float y, float z);

	public void rotate(Quaternoinf rot);

}
*/