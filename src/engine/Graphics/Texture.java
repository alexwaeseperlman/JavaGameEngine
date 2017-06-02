package engine.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;
import org.lwjgl.system.MemoryUtil;

import engine.Engine.Disposable;

public class Texture implements Disposable {
	//This is for texture arrays
	public static class Array {
		public Array(Texture... textures) {

		}
	}

	public final int id;
	private int textureUnit = 0;

	public int getTextureUnit() {
		return textureUnit;
	}

	public void setTextureUnit(int unit) {
		textureUnit = unit;
		GL13.glActiveTexture(GL13.GL_TEXTURE0 + textureUnit);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}

	public Texture() {
		id = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}

	public void bind() {
		GL13.glActiveTexture(GL13.GL_TEXTURE0 + textureUnit);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}

	public void setImage(float[] pixels, int width, int height) {
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_FLOAT, pixels);
	}

	public void setImage(ByteBuffer pixels, int width, int height) {
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
				pixels);
	}

	public void createEmpty(int width, int height) {
		bind();
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, 800, 600, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
				MemoryUtil.NULL);
	}

	public void loadFromFile(String fileName) throws IOException {
		BufferedImage image = ImageIO.read(new File(fileName));
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4); //4 for RGBA, 3 for RGB

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int pixel = pixels[y * image.getWidth() + x];
				buffer.put((byte) ((pixel >> 16) & 0xFF)); // Red component
				buffer.put((byte) ((pixel >> 8) & 0xFF)); // Green component
				buffer.put((byte) (pixel & 0xFF)); // Blue component
				buffer.put((byte) ((pixel >> 24) & 0xFF)); // Alpha component. Only for RGBA
			}
		}

		buffer.flip(); //FOR THE LOVE OF GOD DO NOT FORGET THIS
		setImage(buffer, image.getWidth(), image.getHeight());
	}

	public void dispose() {
		GL11.glDeleteTextures(id);
	}
}