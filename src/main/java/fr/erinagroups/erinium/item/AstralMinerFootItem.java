
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AstralMinerFootItem extends Item {
	public AstralMinerFootItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
