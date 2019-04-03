package minerengine.lwjgl.graphics.forms.customtextures;

import org.lwjgl.opengl.GL11;

import minerengine.lwjgl.graphics.FormRender;

public class TextureDrawner extends FormRender {

	private final float x, y, width, height, red, green, blue, alpha, xo, yo;

	public TextureDrawner(float x, float y, float width, float height, float red, float green, float blue, float alpha,
			float xo, float yo) {
		super(GL11.GL_QUADS);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		this.xo = xo;
		this.yo = yo;
	}

	@Override
	public void render() {
		GL11.glColor4f(this.red, this.green, this.blue, this.alpha);

		GL11.glTexCoord2f(this.xo / 32.0f, this.yo / 32.0f);
		GL11.glVertex2f(x, y);

		GL11.glTexCoord2f(this.xo / 32.0f, (1 + this.yo) / 32.0f);
		GL11.glVertex2f(this.x + this.width, this.y);

		GL11.glTexCoord2f((1 + this.xo) / 32.0f, (1 + this.yo) / 32.0f);
		GL11.glVertex2f(this.x + this.width, this.y + this.height);

		GL11.glTexCoord2f((1 + this.xo) / 32.0f, this.yo / 32.0f);
		GL11.glVertex2f(this.x, this.y + this.height);
	}

	@Override
	public String toString() {
		return "RectangleDrawnerColor";
	}

}
