import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

import engine.*;
import engine.Graphics.*;

class test extends App {
	Shader v;
	VBO vbo;
	VAO vao;
	Texture tex;

	public static void main(String[] args) {
		new test();
		System.out.println("Hello world");
	}

	@Override
	public void setup() {
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, 4);
		window.create(1000, 1000);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL13.GL_MULTISAMPLE);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		tex = new Texture();
		tex.setTextureUnit(0);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		System.out.println("Set texture parameters");
		try {
			tex.loadFromFile("Test.png");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		vbo = new VBO(new float[][] { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } });
		vao = new VAO(vbo);
		v = new Shader(
				"#version 330\nuniform float passedTime;\nout vec2 position;\nlayout(location = 0)in vec2 vecPos; void main() { gl_Position = vec4(vecPos.x + sin(passedTime * 2.2), vecPos.y, 0, cos(passedTime * 3) / 2 + 1); position.xy = vecPos.xy; }",
				"#version 130\n uniform float passedTime; uniform sampler2D img; in vec2 position; out vec4 color; void main() { color = vec4(texture(img, vec2(position.x * sin(passedTime), position.y * sin(sin(passedTime * 1.1)))).rg, sin(passedTime), 1); }");
	}

	@Override
	public void draw() {
		v.uniform.setFloat1("passedTime", time.elapsedTime);
		GL11.glClearColor(0, 0, 0, 0.1f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		v.bind();
		vao.draw(Renderer.drawModes.TRIANGLE_STRIP, 0, 3);
	}

}
