package engine.Engine;

import org.joml.*;

public class Camera {

	/*
	
	[
		1, 0, 0, 0
		0, 1, 0, 0
		0, 0, 0.25, 1
		0, 0, 0, 0
	]
	
	*/

	public static Camera perspective(float width, float height, float fov, float near, float far) {
		Camera c = new Camera();
		c.projection.setPerspective(fov, width / height, near, far);
		return c;
	}

	public static Camera perspective(float width, float height, float fov) {
		return perspective(width, height, fov, 0.01f, 100f);
	}

	public static Camera ortho(float width, float height, float near, float far) {
		Camera c = new Camera();
		c.projection.setOrtho(0, width, height, 0, near, far);
		return c;
	}

	public static Camera ortho(float width, float height) {
		Camera c = new Camera();
		c.projection.setOrtho2D(0, width, height, 0);
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

	public void translate(Vector2f position) {
		view.translate(new Vector3f(position, 0));
	}

	public void rotate(float z) {
		view.rotateZ(z);
	}

	public void rotate(Vector3f rot) {
		view.rotateXYZ(rot);
	}

	public void rotate(float x, float y, float z) {
		view.rotateXYZ(x, y, z);
	}

	public void rotate(Quaternionf rot) {
		view.rotate(rot);
	}

}
