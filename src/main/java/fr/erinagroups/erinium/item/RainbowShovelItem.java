
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.erinagroups.erinium.itemgroup.EriniumToolsItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class RainbowShovelItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:rainbow_shovel")
	public static final Item block = null;

	public RainbowShovelItem(EriniumModElements instance) {
		super(instance, 601);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(EriniumToolsItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("rainbow_shovel"));
	}
}
