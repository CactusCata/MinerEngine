package minerengine.main.gameplay.world.bloc.list;

import java.util.HashMap;
import java.util.Map;

import minerengine.lwjgl.graphics.texture.Texture;

public enum BlockType {

	VOID(1.0f, 1.0f, 1.0f),
	AIR(0.8f, 1.0f, 0.9f),
	STONE(0.412f, 0.412f, 0.412f),
	DIRT(0.647f, 0.165f, 0.165f),
	CHEST(0.0f, 1.0f, 1.0f),
	GRASS(0.133f, 0.545f, 0.133f);

	private final float r, g, b;

	private BlockType(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public final float getR() {
		return this.r;
	}

	public final float getG() {
		return this.g;
	}

	public final float getB() {
		return this.b;
	}

	public static String getEnumPathTexture() {
		return "blocks";
	}

	public static class BlockTypeTextures {

		private static final Map<BlockType, Texture> textures = new HashMap<>();

		static {
			for (BlockType blockType : BlockType.values()) {
				textures.put(blockType, Texture.loadTexture(
						"/res/textures/" + BlockType.getEnumPathTexture() + "/" + blockType.toString() + ".png"));
			}

		}

		public static Texture getTexture(BlockType blockType) {
			return textures.get(blockType);
		}
	}

}
