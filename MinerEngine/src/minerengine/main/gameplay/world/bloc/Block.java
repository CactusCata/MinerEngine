package minerengine.main.gameplay.world.bloc;

import org.lwjgl.opengl.Display;

import minerengine.lwjgl.Render;
import minerengine.lwjgl.graphics.forms.customtextures.TextureDrawner;
import minerengine.lwjgl.graphics.texture.Texture;
import minerengine.main.game.Game;
import minerengine.main.gameplay.world.bloc.list.BlockType;
import minerengine.main.gameplay.world.location.BlockLocation;

public class Block {

	private final BlockType blockType;
	private final byte data;
	private final BlockLocation blockLocation;

	public Block(int x, int y, BlockType blockType) {
		this(x, y, blockType, (byte) 0);
	}

	public Block(BlockLocation blockLocation, BlockType blockType, byte data) {
		this.blockType = blockType;
		this.data = data;
		this.blockLocation = blockLocation;
	}

	public Block(int x, int y, BlockType blockType, byte data) {
		this(new BlockLocation(x, y), blockType, data);
	}

	public final void render() {
		float x0 = this.blockLocation.getX() + Game.getInstance().getXScroll() / 16,
				y0 = this.blockLocation.getY() + Game.getInstance().getYScroll() / 16;

		if (x0 + 16 > 0 && y0 + 16 > 0 && x0 - 1 < Display.getWidth() / 3 / 16
				&& y0 - 1 < Display.getHeight() / 3 / 16) {
			Texture texture = BlockType.BlockTypeTextures.getTexture(blockType);
			texture.bind();
			Render.render(new TextureDrawner(this.blockLocation.getX() * 16, this.blockLocation.getY() * 16, 16, 16,
					this.blockType.getR(), this.blockType.getG(), this.blockType.getG(), 1.0f, 0, 0));
			texture.unbind();

		}
	}

	public final BlockType getBlockType() {
		return this.blockType;
	}

	public final byte getData() {
		return this.data;
	}

}
