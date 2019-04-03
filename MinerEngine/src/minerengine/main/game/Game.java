package minerengine.main.game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import minerengine.lwjgl.graphics.Visionable;
import minerengine.main.gameplay.world.World;
import minerengine.main.gameplay.world.WorldType;
import minerengine.main.settings.Settings;

public final class Game implements Visionable {

	private static Game instance;

	private final Settings settings;
	private final String gameName;
	private final List<World> worlds = new ArrayList<>();
	private float xScroll, yScroll;

	public Game(String gameName, Settings settings) {
		instance = this;
		this.gameName = gameName;
		this.settings = settings;
		this.worlds.add(new World(WorldType.NORMAL));
	}

	public final void translateView(float xa, float ya) {
		this.xScroll += xa;
		this.yScroll += ya;
	}

	@Override
	public final void init() {
		this.worlds.forEach(world -> world.init());
	}

	public final float getXScroll() {
		return this.xScroll;
	}

	public final float getYScroll() {
		return this.yScroll;
	}

	@Override
	public final void update() {
		this.translateView(-0.1f, -0.1f);
		this.worlds.forEach(world -> world.update());
	}

	@Override
	public final void render() {
		GL11.glTranslated(this.xScroll, this.yScroll, 0);
		this.worlds.forEach(world -> world.render());
	}

	public final Settings getSettings() {
		return this.settings;
	}

	public final String getGameName() {
		return this.gameName;
	}

	public final static Game getInstance() {
		return instance;
	}

}
