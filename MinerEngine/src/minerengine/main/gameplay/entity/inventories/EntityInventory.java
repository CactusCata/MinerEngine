package minerengine.main.gameplay.entity.inventories;

public final class EntityInventory extends Inventory {

	private final Inventory armor = new Inventory("Armor", 4);
	private final Inventory hand = new Inventory("Hand", 1);

	public EntityInventory() {
		super(InventoryType.PLAYER);
	}

	public final Inventory getArmor() {
		return this.armor;
	}

	public final Inventory getHand() {
		return this.hand;
	}

}
