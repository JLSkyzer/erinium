
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import fr.erinagroups.erinium.itemgroup.SetanumTabItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class SetanumAxeItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:setanum_axe")
	public static final Item block = null;

	public SetanumAxeItem(EriniumModElements instance) {
		super(instance, 346);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 32;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SetanumIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(SetanumTabItemGroup.tab)) {
		}.setRegistryName("setanum_axe"));
	}
}
