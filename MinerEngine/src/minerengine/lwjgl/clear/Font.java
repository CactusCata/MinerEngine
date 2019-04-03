package minerengine.lwjgl.clear;

import org.lwjgl.opengl.GL11;

public final class Font {

	private final float red, green, blue, alpha;

	public Font(float red, float green, float blue, float alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public final void setFont() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(this.red, this.green, this.blue, this.alpha);
	}

}
