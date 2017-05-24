package engine.Graphics;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import engine.Input.Keyboard;
import engine.Input.Mouse;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {
	private long windowID;
	public long getID() {
		return windowID;
	}
	private int width;
	private int height;
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	private int fbWidth;
	private int fbHeight;
	public int getFbWidth() {
		return fbWidth;
	}
	public int getFbHeight() {
		return fbHeight;
	}
	public void setWidth(int w) {
		glfwSetWindowSize(windowID, w, height);
	}
	public void setHeight(int h) {
		glfwSetWindowSize(windowID, width, h);
	}
	static {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");
	}
	public void create(int w, int h) {
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will be resizable
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		width = w;
		height = h;

		windowID = glfwCreateWindow(width, height, "Hello World!", NULL, NULL);

		if (windowID == NULL)
			System.err.println("Unable to create window");

		makeContext();
		glfwSwapInterval(1);
		GL.createCapabilities();
		glfwShowWindow(windowID);
		Mouse.registerWindow(windowID);
		Keyboard.registerWindow(windowID);

		glfwSetWindowSizeCallback(windowID, new GLFWWindowSizeCallback() {
			@Override public void invoke(long win, int x, int y) {
				width = x;
				height = y;
				resized(x, y);
			}
		});

		glfwSetFramebufferSizeCallback(windowID, new GLFWFramebufferSizeCallback() {
			@Override public void invoke(long win, int x, int y) {
				fbWidth = x;
				fbHeight = y;
				framebufferResized(x, y);
			}
		});

		glfwSetWindowCloseCallback(windowID, new GLFWWindowCloseCallback() {
			@Override public void invoke(long win) {
				closed();
			}
		});

		glfwSetWindowPosCallback(windowID, new GLFWWindowPosCallback() {
			@Override public void invoke(long win, int x, int y) {
				moved(x, y);
			}
		});
		
		glfwSetWindowIconifyCallback(windowID, new GLFWWindowIconifyCallback() {
			@Override public void invoke(long win, boolean iconified) {
				if (iconified) minimized();
				else expanded();
			}
		});

		glfwSetWindowFocusCallback(windowID, new GLFWWindowFocusCallback() {
			@Override public void invoke(long win, boolean f) {
				if (f) focused();
				else blurred();
			}
		});

		glfwSetWindowRefreshCallback(windowID, new GLFWWindowRefreshCallback() {
			@Override public void invoke(long win) {
				reloaded();
			}
		});
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public void makeContext() {
		glfwMakeContextCurrent(windowID);
	}

	public void moveTo(int x, int y) {
		glfwSetWindowPos(windowID, x, y);
	}

	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	public boolean open() {
		glfwPollEvents();
		glfwSwapBuffers(windowID); // swap the color buffers

		return !glfwWindowShouldClose(windowID);
	}

	public void resized(int width, int height) {

	}
	public void framebufferResized(int width, int height) {

	}
	public void closed() {

	}
	public void moved(int x, int y) {

	}
	public void minimized() {

	}
	public void focused() {

	}
	public void reloaded() {

	}
	public void expanded() {

	}
	public void blurred() {

	}
	public void setTitle(String title) {
		glfwSetWindowTitle(windowID, title);
	}
}