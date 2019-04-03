package minerengine.lwjgl.graphics;

import org.lwjgl.opengl.GL11;

public abstract class FormRender {

	private final int glValueForm;

	public FormRender(int glValueForm) {
		this.glValueForm = glValueForm;
	}

	public abstract void render();

	public final void begin() {
		GL11.glBegin(this.glValueForm);
	}

	public final void end() {
		GL11.glEnd();
	}
	
}
