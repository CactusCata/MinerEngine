package minerengine.lwjgl;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import minerengine.lwjgl.clear.Font;
import minerengine.main.game.Game;
import minerengine.main.game.actions.Running;

public final class LwjglWindows {

	private final int scale = 3;
	private int width = 720 / this.scale, height = 480 / this.scale;
	private final Running running = new Running(false);
	private final Updater updater = new Updater();
	private final Render render = new Render(this.updater, 8,
			new Font(0.3941176470588235f, 0.6529411764705882f, 1.0f, 1.0f));
	private final Game game;
	private final String titleFormat;

	public LwjglWindows(Game game) {
		this.game = game;
		this.titleFormat = this.game.getGameName() + " | ticks %d | fps: %d";
	}

	public final void createWindows() {
		try {
			Display.setDisplayMode(new DisplayMode(this.width * this.scale, this.height * this.scale));
			Display.setResizable(true);
			Display.setFullscreen(false);
			Display.setTitle(String.format(this.titleFormat, 0, 0));
			Display.create();
			this.view2D();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public final void start() {
		this.running.setRunning(true);
		this.loop();
	}

	public final void loop() {

		this.game.init();

		long timer = System.currentTimeMillis(), before = System.nanoTime();
		int ticks = 0, frames = 0;

		final double nanoSecond = 1000000000 / this.game.getSettings().getFpsMax();

		while (this.running.isRunning()) {
			if (Display.isCloseRequested())
				this.stop();
			Display.update();

			this.updater.setTicks(false);
			this.render.setRender(false);

			if (System.nanoTime() - before > nanoSecond) {
				before += nanoSecond;
				this.updater.setTicks(true);
				ticks++;
			} else {
				this.render.setRender(true);
				frames++;
			}

			if (this.updater.isTicks()) {
				this.updater.update();
				this.game.update();
			}
			if (this.render.isRender()) {
				this.width = Display.getWidth() / this.scale;
				this.height = Display.getHeight() / this.scale;
				this.view2D();
				this.render.setupFont();
				this.game.render();
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				Display.setTitle(String.format(titleFormat, frames, ticks));
				ticks = 0;
				frames = 0;
			}

		}
		this.exit();
	}

	public final void stop() {
		this.running.setRunning(false);
	}

	private final void view2D() {
		GL11.glViewport(0, 0, this.width * this.scale, this.height * this.scale);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluOrtho2D(0, width, height, 0);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public final void exit() {
		Display.destroy();
		System.exit(0);

	}

}
