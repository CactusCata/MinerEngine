package minerengine.lwjgl;

import minerengine.lwjgl.clear.Font;
import minerengine.lwjgl.graphics.FormRender;
import minerengine.lwjgl.graphics.GroupForm;

public class Render {

	private final Updater updater;
	private boolean render;
	private final float slowness;
	private final Font fontClear;

	public Render(Updater updater, float slowness, Font fontClearn) {
		this.updater = updater;
		this.slowness = slowness;
		this.fontClear = fontClearn;
	}

	public Render(Updater updater, Font fontClearn) {
		this(updater, 1.0f, fontClearn);
	}

	public final void setupFont() {
		this.fontClear.setFont();
	}

	public final void rend(GroupForm groupForm) {
		groupForm.draw();
	}

	public static final void render(FormRender... formRenders) {
		for (FormRender frender : formRenders) {
			frender.begin();
			frender.render();
			frender.end();
		}
	}

	// public final void rend() {
	// GroupForm groupForm = new GroupForm();
	// groupForm.add(
	// new RectangleDrawnerColor(16.0f + this.updater.getTime() / this.slowness,
	// 16.0f + this.updater.getTime() / this.slowness, 16.0f, 16.0f, 0.5f, 1.0f,
	// 0.8f),
	// new RectangleDrawner(160.0f + this.updater.getTime() / this.slowness,
	// 6.0f + this.updater.getTime() / this.slowness, 2.0f, 16.0f));
	// this.rend(groupForm);
	// }

	public boolean isRender() {
		return this.render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

}
