package engine.Graphics;

import org.lwjgl.opengl.*;

import engine.Engine.Disposable;

public class FrameBuffer implements Disposable {
	public final int id;
	private int attachments = 0;

	public FrameBuffer() {
		id = GL30.glGenFramebuffers();
		bind();
	}

	public void attachTexture(Texture texture) {
		attachTexture(texture.id);
	}

	public void attachTexture(int texID) {
		GL30.glFramebufferTexture2D(GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0 + attachments++, GL11.GL_TEXTURE_2D,
				texID, 0);
	}

	public void bind() {
		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, id);
	}

	public void unbind() {
		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
	}

	public void dispose() {
		GL30.glDeleteFramebuffers(id);
	}
}