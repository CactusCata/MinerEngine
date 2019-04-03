package minerengine.main.gameplay.entity.inventories;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import minerengine.main.gameplay.entity.items.Item;
import minerengine.main.gameplay.entity.items.types.ItemType;
import minerengine.main.utils.ArrayFiller;
import minerengine.main.utils.StringUtils;

public class Inventory extends AbstractCollection<Item> {

	private final Item[] items;

	public Inventory(String name, int size) {
		this.items = ArrayFiller.fillAndGet(new Item[size], new Item(ItemType.AIR));
	}

	public Inventory(InventoryType inventoryType) {
		this(StringUtils.capitalize(inventoryType.name()), inventoryType.getSize());
	}

	public final void setItem(Item item, int slot) {
		this.items[slot] = item;
	}

	public final Item getItem(int slot) {
		return this.items[slot];
	}

	public final boolean slotIsEmpty(int slot) {
		return this.items[slot].getItemType() == ItemType.AIR;
	}

	public final int getSlot(Item item) {
		for (int i = 0, size = this.items.length; i < size; i++)
			if (item.likeWithOutNumber(this.items[i]))
				return i;
		return -1;
	}

	public final void remove(ItemType itemType) {
		remove(new Item(itemType));
	}

	public final void clear() {
		ArrayFiller.fill(this.items, new Item(ItemType.AIR));
	}

	@Override
	public final boolean add(Item item) {
		if (contains(item))
			this.items[this.getSlot(item)].getAmount().addValue(item.getAmount().getValue());
		else
			this.items[getSlot(new Item(ItemType.AIR))] = item;
		return true;
	}

	@Override
	public final boolean contains(Object item) {
		return item instanceof Item && getSlot((Item) item) != -1;
	}

	@Override
	public final boolean isEmpty() {
		for (int i = 0, size = this.size(); i < size; i++)
			if (!this.slotIsEmpty(i))
				return false;
		return true;
	}

	@Override
	public final boolean remove(Object item) {
		if (item instanceof Item && this.contains((Item) item))
			this.items[getSlot((Item) item)] = new Item(ItemType.AIR);
		return true;
	}

	@Override
	public final boolean removeAll(Collection<?> c) {
		for (Object item : c)
			remove(item);
		return true;
	}

	@Override
	public final int size() {
		return this.items.length;
	}

	@Override
	public final Object[] toArray() {
		return this.items;
	}

	@Override
	public final Iterator<Item> iterator() {
		return new Iterator<Item>() {

			private int pos = 0;

			@Override
			public final boolean hasNext() {
				return Inventory.this.items.length > pos;
			}

			@Override
			public final Item next() {
				return Inventory.this.items[pos++];
			}
		};
	}

}
