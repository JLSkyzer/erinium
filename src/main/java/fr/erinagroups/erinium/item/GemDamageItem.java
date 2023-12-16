
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GemDamageItem extends Item {
	public GemDamageItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
