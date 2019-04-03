package minerengine.main.gameplay.entity.items.enchantements;

public class Enchantement {

	private final EnchantementType enchantementType;
	private final int level;

	public Enchantement(EnchantementType enchantementType, int level) {
		this.enchantementType = enchantementType;
		this.level = level;
	}

	public final EnchantementType getEnchantementType() {
		return enchantementType;
	}

	public final int getLevel() {
		return level;
	}

}
