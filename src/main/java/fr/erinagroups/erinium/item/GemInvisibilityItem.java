
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GemInvisibilityItem extends Item {
	public GemInvisibilityItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
