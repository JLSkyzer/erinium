
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import fr.erinagroups.erinium.init.EriniumModFluids;

public class HotWaterItem extends BucketItem {
	public HotWaterItem() {
		super(EriniumModFluids.HOT_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE));
	}
}
