
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.erinagroups.erinium.itemgroup.EriniumToolsItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class EriniumMatrixPickaxeItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:erinium_matrix_pickaxe")
	public static final Item block = null;

	public EriniumMatrixPickaxeItem(EriniumModElements instance) {
		super(instance, 633);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EriniumMatrixIngotItem.block));
			}
		}, 1, -1f, new Item.Properties().group(EriniumToolsItemGroup.tab)) {
		}.setRegistryName("erinium_matrix_pickaxe"));
	}
}
