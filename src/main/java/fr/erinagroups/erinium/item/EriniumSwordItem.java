
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.erinagroups.erinium.itemgroup.EriniumTabItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class EriniumSwordItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:erinium_sword")
	public static final Item block = null;

	public EriniumSwordItem(EriniumModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 6.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EriniumIngotItem.block));
			}
		}, 3, 96f, new Item.Properties().group(EriniumTabItemGroup.tab)) {
		}.setRegistryName("erinium_sword"));
	}
}
