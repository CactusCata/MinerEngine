package minerengine.main.gameplay.entity.inventories;

public enum InventoryType {

	CHEST(81),
	PLAYER(27),
	MONSTER(),
	CUSTOM();

	private final int size;

	private InventoryType(int size) {
		this.size = size;
	}

	private InventoryType() {
		this(1000);
	}

	public final int getSize() {
		return this.size;
	}

}
