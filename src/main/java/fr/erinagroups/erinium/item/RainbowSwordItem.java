
package fr.erinagroups.erinium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.erinagroups.erinium.itemgroup.EriniumToolsItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class RainbowSwordItem extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:rainbow_sword")
	public static final Item block = null;

	public RainbowSwordItem(EriniumModElements instance) {
		super(instance, 598);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 6.8f;
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
		}, 3, 96f, new Item.Properties().group(EriniumToolsItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("rainbow_sword"));
	}
}
