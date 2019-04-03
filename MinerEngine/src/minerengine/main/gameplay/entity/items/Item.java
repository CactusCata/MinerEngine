package minerengine.main.gameplay.entity.items;

import java.util.HashMap;
import java.util.Map;

import minerengine.main.gameplay.entity.items.enchantements.Enchantement;
import minerengine.main.gameplay.entity.items.enchantements.EnchantementType;
import minerengine.main.gameplay.entity.items.types.ItemType;
import minerengine.main.utils.Modifier;
import minerengine.main.utils.StringUtils;

public class Item {

	private final Modifier amount, damageValue, damage;
	private String name;
	private byte data;
	private final Map<EnchantementType, Enchantement> enchantements = new HashMap<>();
	private final ItemType itemType;

	public Item(ItemType itemType, int amount, int damageValue, byte data) {
		this.itemType = itemType;
		this.damageValue = new Modifier(damageValue);
		this.amount = new Modifier(amount);
		this.damage = new Modifier(this.getItemType().getBasicDamage());
		this.setData(data);
		this.setName(StringUtils.capitalize(this.itemType.name()));
	}

	public Item(ItemType itemType, int amount) {
		this(itemType, amount, 0, (byte) 0);
	}

	public Item(ItemType itemType) {
		this(itemType, 1);
	}

	public final Enchantement getEnchantement(EnchantementType enchantementType) {
		return enchantements.get(enchantementType);
	}

	public final void addEnchantement(Enchantement enchantement) {
		this.enchantements.put(enchantement.getEnchantementType(), enchantement);
		switch (enchantement.getEnchantementType()) {
		case SHARPNESS:
			this.getDamage().addValue(enchantement.getLevel());
			return;
		case WEEKNESS:
			this.getDamage().removeValue(enchantement.getLevel());
		}
	}

	public final void removeEnchantement(EnchantementType enchantementType) {
		if (enchantements.containsKey(enchantementType)) {
			Enchantement enchantement = this.enchantements.get(enchantementType);
			this.enchantements.remove(enchantementType);
			switch (enchantementType) {
			case SHARPNESS:
				this.getDamage().removeValue(enchantement.getLevel());
				return;
			case WEEKNESS:
				this.getDamage().addValue(enchantement.getLevel());
			}
		}
	}

	public final ItemType getItemType() {
		return this.itemType;
	}

	public final Modifier getAmount() {
		return amount;
	}

	public final Modifier getDamageValue() {
		return damageValue;
	}

	public final Modifier getDamage() {
		return damage;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final byte getData() {
		return data;
	}

	public final void setData(byte data) {
		this.data = data;
	}

	public final boolean equals(Item item) {
		return this.likeWithOutNumber(item) && this.getAmount().getValue() == item.getAmount().getValue();
	}

	public final boolean likeWithOutNumber(Item item) {
		return this.getItemType() == item.getItemType()
				&& this.getDamageValue().getValue() == item.getAmount().getValue()
				&& this.getName().equals(item.getName()) && this.getData() == item.getData();
	}
}
