
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.erinagroups.erinium.itemgroup.EriniumItemsItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class GemRegenerationItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:gem_regeneration")
	public static final Item block = null;

	public GemRegenerationItem(EriniumModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(EriniumItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("gem_regeneration");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
