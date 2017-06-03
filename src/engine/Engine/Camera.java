package engine.Engine;

import org.joml.*;

import engine.Graphics.Uniform;

public class Camera {
	// translate, getPosition, setPosition
	private Vector3f position = new Vector3f(0, 0, 0);

	public Vector3fc getPosition() {
		return position;
	}

	// rotate, getRotation, getEulerRotation, setRotation
	private Quaternionf rotation = new Quaternionf();
	private Quaternionf invertedRotation = new Quaternionf();

	public Quaternionfc getRotation() {
		return rotation;
	}

	// scale(vec3), scale(float), getScale
	private Vector3f scale = new Vector3f(1, 1, 1);

	public Vector3fc getScale() {
		return scale;
	}

	private boolean ortho;

	private float width = 1;
	private float height = -1;
	private float far = 1;
	private float near = 0.01f;
	private float fieldOfView = 60;

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getFar() {
		return far;
	}

	public float getNear() {
		return near;
	}

	public void setWidth(float newValue) {
		width = newValue;
		if (ortho)
			ortho();
		else
			perspective();
	}

	public void setHeight(float newValue) {
		height = newValue;
		if (ortho)
			ortho();
		else
			perspective();
	}

	public void setFar(float newValue) {
		far = newValue;
		if (ortho)
			ortho();
		else
			perspective();
	}

	public void setNear(float newValue) {
		near = newValue;
		if (ortho)
			ortho();
		else
			perspective();
	}

	public static enum Projection {
		ORTHOGRAPHIC, PERSPECTIVE;
	}

	public Projection getProjection() {
		return ortho ? Projection.ORTHOGRAPHIC : Projection.PERSPECTIVE;
	}

	public void ortho() {
		ortho = true;
		projection.set(1 / width, 0, 0, 0, //
				0, 1 / height, 0, 0, //
				0, 0, -2 / (far - near), -((far + near) / (far - near)), //
				0, 0, 0, 1);
	}

	public void perspective() {
		ortho = false;
		projection.set(near / width, 0, 0, 0, //
				0, near / height, 0, 0, //
				0, 0, /* This is possibly incorrect */ (-(far + near) / (far - near)), (-2 * far * near / (far - near)), //
				0, 0, /* This also is possibly incorrect */-1, 0);
	}

	public float getFieldOfView() {
		return fieldOfView;
	}

	private Matrix4f view = new Matrix4f();

	private void updateView() {
		view.identity();
		view.translate(-position.x, -position.y, -position.z);
		rotation.invert(invertedRotation);
		view.rotate(invertedRotation);
		view.scale(scale);
	}

	public void translate(Vector3fc target) {
		position.add(target);
		updateView();
	}

	public void translate(float x, float y, float z) {
		position.add(x, y, z);
		updateView();
	}

	public void translate(Vector2fc target) {
		position.add(target.x(), target.y(), 0);
		updateView();
	}

	public void translate(float x, float y) {
		position.add(x, y, 0);
		updateView();
	}

	public void setTranslation(Vector3fc target) {
		position.set(target);
		updateView();
	}

	public void setTranslation(float x, float y, float z) {
		position.set(x, y, z);
		updateView();
	}

	public void setTranslation(Vector2fc target) {
		position.set(target.x(), target.y(), 0);
	}

	public void setTranslation(float x, float y) {
		position.set(x, y, 0);
	}

	public void rotate(float z) {
		rotation.rotateZ(z);
		updateView();
	}

	public void rotate(float x, float y, float z) {
		rotation.rotate(x, y, z);
		updateView();
	}

	public void rotate(Vector3fc target) {
		rotation.rotateZYX(target.x(), target.y(), target.z());
		updateView();
	}

	public void rotate(Quaternionfc target) {
		rotation.add(target);
		updateView();
	}

	public void setRotation(Quaternionf target) {
		rotation.set(target);
		updateView();
	}

	public void setRotation(float x, float y, float z) {
		rotation.set(x, y, z);
		updateView();
	}

	public void setRotation(float x, float y, float z, float w) {
		rotation.set(x, y, z, w);
		updateView();
	}

	public void scale(float amount) {
		scale(amount, amount, amount);
		updateView();
	}

	public void scale(Vector2fc amount) {
		scale(amount.x(), amount.y());
	}

	public void scale(float x, float y) {
		scale(x, y, 0);
	}

	public void scale(Vector3fc amount) {
		scale(amount.x(), amount.y(), amount.z());
	}

	public void scale(float x, float y, float z) {
		scale.add(x, y, z);
		updateView();
	}

	public void setScale(float amount) {
		setScale(amount, amount, amount);
		updateView();
	}

	public void setScale(Vector2fc amount) {
		setScale(amount.x(), amount.y());
	}

	public void setScale(float x, float y) {
		setScale(x, y, 0);
	}

	public void setScale(Vector3fc amount) {
		setScale(amount.x(), amount.y(), amount.z());
	}

	public void setScale(float x, float y, float z) {
		scale.set(x, y, z);
		updateView();
	}

	private Matrix4f projection = new Matrix4f();
	private Matrix4f combined = new Matrix4f();

	public Matrix4fc getViewMatrix() {
		return view;
	}

	public Matrix4fc getProjectionMatrix() {
		return projection;
	}

	public Matrix4fc getMatrix() {
		view.mul(projection, combined);
		return combined;
	}

	public Camera() {
		ortho();
	}

	public void setUniform(Uniform uniform, String name) {
		uniform.setMatrix4(name, getMatrix());
	}
}
