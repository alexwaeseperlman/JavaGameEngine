package engine.Engine;

import java.lang.Thread;

import engine.App;
public class Runner extends Thread {
	private App app;
	public Runner(App app) {
		this.app = app;
	}
	@Override public void run() {
		app.init();
		do {
			long start = System.nanoTime();
			app.update();
			app.time.tick(System.nanoTime() - start);
		} while (app.window.open());
	}
}