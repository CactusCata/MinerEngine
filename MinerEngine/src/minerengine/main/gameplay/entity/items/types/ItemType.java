package minerengine.main.gameplay.entity.items.types;

public enum ItemType {

	AIR(),
	STONE(),
	COBBLE_STONE(),
	DIRT(),
	GRASS(),

	WOODEN_SWORD(3, ValueType.ATTACK),
	STONE_SWORD(4, ValueType.ATTACK),
	IRON_SWORD(5, ValueType.ATTACK),
	GOLDEN_SWORD(6, ValueType.ATTACK),
	DIAMOND_SWORD(7, ValueType.ATTACK);

	private final int basicDamage;
	private final ValueType valueType;

	private ItemType() {
		this(0, ValueType.NULL);
	}

	private ItemType(int basicDamage, ValueType valueType) {
		this.basicDamage = basicDamage;
		this.valueType = valueType;
	}

	public final int getBasicDamage() {
		return this.basicDamage;
	}

	public ValueType getValueType() {
		return this.valueType;
	}

	public static enum ValueType {
		ATTACK,
		DEFENSE,
		NULL;
	}

}
