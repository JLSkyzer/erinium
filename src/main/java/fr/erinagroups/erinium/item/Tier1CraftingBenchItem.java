
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class Tier1CraftingBenchItem extends Item {
	public Tier1CraftingBenchItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
