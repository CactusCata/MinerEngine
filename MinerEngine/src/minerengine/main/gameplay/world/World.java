package minerengine.main.gameplay.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import minerengine.lwjgl.graphics.Visionable;
import minerengine.main.gameplay.entity.Entity;
import minerengine.main.gameplay.world.bloc.Block;
import minerengine.main.gameplay.world.bloc.list.BlockType;

public final class World implements Visionable {

	private final WorldType worldType;
	private final Block[][] blocks = new Block[255][255];
	private final List<Entity> entities = new ArrayList<>();

	public World(WorldType worldType) {
		this.worldType = worldType;
		this.generate();
	}

	public final WorldType getWorldType() {
		return this.worldType;
	}

	public final void generate() {
		Random r = new Random();
		for (int x = 0, xMax = this.blocks.length; x < xMax; x++)
			for (int y = 0, yMax = this.blocks[x].length; y < yMax; y++) {
				setBlock(x, y, new Block(x, y, r.nextBoolean() ? BlockType.STONE : BlockType.GRASS));
			}
	}

	public final void setBlock(int x, int y, Block block) {
		this.blocks[x][y] = block;
	}

	public final void removeBlock(int x, int y) {
		this.setBlock(x, y, new Block(x, y, BlockType.AIR));
	}

	public final Block[][] getBlocks() {
		return this.blocks;
	}

	public final void spawnEntity(Entity entity) {
		entities.add(entity);
	}

	public final void removeEntity(Entity entity) {
		entities.remove(entity);
	}

	@Override
	public final void init() {

	}

	@Override
	public final void update() {

	}

	@Override
	public final void render() {
		for (Block[] yBlock : this.blocks)
			for (Block xBlock : yBlock)
				xBlock.render();
	}

}
