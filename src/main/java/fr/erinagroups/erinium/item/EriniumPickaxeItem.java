
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.erinagroups.erinium.itemgroup.EriniumTabItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class EriniumPickaxeItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:erinium_pickaxe")
	public static final Item block = null;

	public EriniumPickaxeItem(EriniumModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EriniumIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(EriniumTabItemGroup.tab)) {
		}.setRegistryName("erinium_pickaxe"));
	}
}
