package minerengine.lwjgl.graphics.forms.rectangle;

import org.lwjgl.opengl.GL11;

public class RectangleDrawnerColor extends RectangleDrawner {

	private final float red, green, blue, alpha;

	public RectangleDrawnerColor(float x, float y, float width, float height, float red, float green, float blue,
			float alpha) {
		super(x, y, width, height);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	@Override
	public void render() {
		super.render();
		GL11.glColor4f(this.red, this.green, this.blue, this.alpha);
	}

	@Override
	public String toString() {
		return "RectangleDrawnerColor";
	}

}
