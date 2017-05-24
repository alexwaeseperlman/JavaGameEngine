package engine.Input;

import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import org.joml.*;

public class Mouse {
	public long windowID = -1;
	public long getWindowID() {
		return windowID;
	}
	private static Vector2f position = new Vector2f(0, 0);
	private static Vector2f previousPosition = new Vector2f(0, 0);
	private static ArrayList<Long> initializedWindows = new ArrayList<Long>();
	private static ArrayList<Mouse> mouses = new ArrayList<Mouse>();
	public boolean pressed = false;

	public Vector2fc getPosition() {
		return position;
	}
	public void setPosition(Vector2f value) {
		previousPosition.set(position);
		position = value;
		glfwSetCursorPos(windowID, value.x, value.y);
	}
	public Vector2fc getPreviousPosition() {
		return previousPosition;
	}
	public Mouse() {
		mouses.add(this);
	}

	public static void registerWindow(long window) {
		if (initializedWindows.indexOf(window) == -1) {
			initializedWindows.add(window);
			glfwSetCursorPosCallback(window, new GLFWCursorPosCallback() {
				@Override public void invoke(long window, double xPos, double yPos) {
					previousPosition.set(position);
					position.set((float)xPos, (float)yPos);
					for (int i = 0; i < mouses.size(); i++) {
						if (mouses.get(i).windowID == window || mouses.get(i).windowID == -1) {
							mouses.get(i).moved((Vector2fc)position);
						}
					}
				}
			});

			glfwSetCursorEnterCallback(window, new GLFWCursorEnterCallback() {
				@Override public void invoke(long window, boolean entered) {
					for (int i = 0; i < mouses.size(); i++) {
						if (mouses.get(i).windowID == window || mouses.get(i).windowID == -1) {
							if (entered) {
								mouses.get(i).entered();
							}
							else {
								mouses.get(i).exited();
							}
						}
					}
				}
			});

			glfwSetMouseButtonCallback(window, new GLFWMouseButtonCallback() {
				@Override public void invoke(long window, int button, int action, int mods) {
					for (int i = 0; i < mouses.size(); i++) {
						if (mouses.get(i).windowID == window || mouses.get(i).windowID == -1) {
							if (action == GLFW_PRESS) {
								mouses.get(i).pressed(button);
							}
							else if (action == GLFW_RELEASE) {
								mouses.get(i).released(button);
							}
						}
					}
				}
			});
			glfwSetScrollCallback(window, new GLFWScrollCallback() {
				@Override public void invoke(long window, double x, double y) {
					for (int i = 0; i < mouses.size(); i++) {
						if (mouses.get(i).windowID == window || mouses.get(i).windowID == -1) {
							mouses.get(i).scrolled(x, y);
						}
					}
				}
			});
		}
	}
	public void pressed(int button) {

	}
	public void released(int button) {

	}
	public void moved(Vector2fc newPos) {

	}
	public void entered() {

	}
	public void exited() {

	}
	public void scrolled(double x, double y) {

	}
}