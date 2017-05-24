package engine.Engine;

import java.util.ArrayList;

import org.joml.*;

public class Entity implements Cleanable {
	private Entity parent;
	private ArrayList<Entity> children = new ArrayList<Entity>();
	public Vector3f position = new Vector3f();
	public Quaternionf rotation = new Quaternionf();
	public Vector3f scale = new Vector3f();
	public Entity getParent() {
		return parent;
	}
	public void setParent(Entity p) {
		parent = p;
	}
	public void addChild(Entity c) {
		children.add(c);
		c.parent = this;
	}
	public void removeChild(Entity c) {
		int index = children.indexOf(c);
		if (index > -1) {
			c.parent = null;
			children.remove(children.indexOf(c));
		}
	}
	public Entity(Entity p) {
		parent = p;
	}
	protected void render(Matrix4fc model) {

	}
	public void draw(Vector3f position, Quaternionf rotation, Vector3f scale) {
		Matrix4f mat = new Matrix4f();
		mat.translate(position);
		mat.scale(scale);
		mat.rotate(rotation);
		render(mat);
		for (int i = 0; i < children.size(); i++) {
			Vector3f childPosition = new Vector3f();
			childPosition.set(children.get(i).position);
			childPosition.add(position);

			Quaternionf childRotation = new Quaternionf();
			childRotation.set(children.get(i).rotation);
			childRotation.add(rotation);

			Vector3f childScale = new Vector3f();
			childScale.set(children.get(i).scale);
			childScale.add(scale);

			children.get(i).draw(childPosition, childRotation, childScale);
		}
	}
	public void draw() {
		draw(position, rotation, scale);
	}
	public void cleanUp() {

	}
}