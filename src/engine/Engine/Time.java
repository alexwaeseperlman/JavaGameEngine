package engine.Engine;

public class Time {
	public float elapsedTime = 0;
	public float deltaTime = 0;
	public int maxFrameRate = 60;
	public float frameRate = 60;
	public float averageFrameRate = 0;
	public long frameCount = 0;
	void tick(long timeTaken) {
		long timePerFrame = (long)((1f / maxFrameRate) * 1e9f);
		long start = System.nanoTime();
		while (System.nanoTime() - start < timePerFrame - timeTaken) {

		}
		deltaTime = (float)Math.max(timeTaken, timePerFrame) / 1e9f;
		elapsedTime += deltaTime;
		frameRate = 1/deltaTime;
		frameCount++;
		averageFrameRate = frameCount / elapsedTime;
	}
	public Time() {
		
	}
}