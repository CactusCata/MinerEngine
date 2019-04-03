package minerengine.lwjgl.graphics.forms.rectangle;

import org.lwjgl.opengl.GL11;

import minerengine.lwjgl.graphics.FormRender;

public class RectangleDrawner extends FormRender {

	private final float x, y, width, height;

	public RectangleDrawner(float x, float y, float width, float height) {
		super(GL11.GL_QUADS);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void render() {
		GL11.glVertex2f(this.x, this.y);
		GL11.glVertex2f(this.x + this.width, this.y);
		GL11.glVertex2f(this.x + this.width, this.y + this.height);
		GL11.glVertex2f(this.x, this.y + this.height);
	}
	
	@Override
	public String toString() {
		return "RectangleDrawner";
	}

}
