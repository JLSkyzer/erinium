
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LaserDrillItem extends Item {
	public LaserDrillItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}
}
