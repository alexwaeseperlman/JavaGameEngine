package engine;

import org.joml.Vector2fc;

import engine.Engine.*;
import engine.Graphics.*;
import engine.Input.*;
public class App {
	public Time time = new Time();
	private Runner runner = new Runner(this);
	public Window window;
	public Renderer renderer;
	public Mouse mouse;
	public Keyboard keyboard;
	public Entity root = new Entity(null);
	public App() {
		App self = this;
		window = new Window() {
			@Override public void resized(int width, int height) {
				self.windowResized(width, height);
			}
			@Override public void framebufferResized(int width, int height) {
				self.windowFramebufferResized(width, height);
			}
			@Override public void closed() {
				self.windowClosed();
			}
			@Override public void moved(int x, int y) {
				self.windowMoved(x, y);
			}
			@Override public void minimized() {
				self.windowMinimized();
			}
			@Override public void focused() {
				self.windowFocused();
			}
			@Override public void reloaded() {
				self.windowReloaded();
			}
			@Override public void expanded() {
				self.windowExpanded();
			}
			@Override public void blurred() {
				self.windowBlurred();
			}
		};
		renderer = new Renderer(window);
		mouse = new Mouse() {
			@Override public void pressed(int button) {
				self.mousePressed(button);
			}
			@Override public void released(int button) {
				self.mouseReleased(button);
			}
			@Override public void moved(Vector2fc position) {
				self.mouseMoved(position);
			}
			@Override public void entered() {
				self.mouseEntered();
			}
			@Override public void exited() {
				self.mouseExited();
			}
		};
		keyboard = new Keyboard() {
			@Override public void pressed(int key) {
				self.keyPressed(key);
			}
			@Override public void released(int key) {
				self.keyReleased(key);
			}
			@Override public void typed(char key) {
				self.keyTyped(key);
			}
		};
		
		runner.start();
	}
	public final void init() {
		setup();
	}
	public final void update() {
		draw();
		root.draw();
	}
	public void draw() {

	}
	public void setup() {
		
	}
	public void mousePressed(int button) {

	}
	public void mouseReleased(int button) {

	}
	public void mouseEntered() {
		
	}
	public void mouseExited() {

	}
	public void mouseMoved(Vector2fc newPos) {

	}
	public void windowResized(int width, int height) {

	}
	public void windowFramebufferResized(int width, int height) {

	}
	public void windowClosed() {

	}
	public void windowMoved(int x, int y) {

	}
	public void windowMinimized() {

	}
	public void windowFocused() {

	}
	public void windowReloaded() {

	}
	public void windowExpanded() {

	}
	public void windowBlurred() {

	}
	
	public void keyPressed(int key) {
		
	}
	public void keyTyped(char key) {

	}
	public void keyReleased(int key) {

	}
}