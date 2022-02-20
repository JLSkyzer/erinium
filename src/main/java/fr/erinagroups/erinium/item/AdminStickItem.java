
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.erinagroups.erinium.itemgroup.AdminZoneItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class AdminStickItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:admin_stick")
	public static final Item block = null;

	public AdminStickItem(EriniumModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AdminZoneItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("admin_stick");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
