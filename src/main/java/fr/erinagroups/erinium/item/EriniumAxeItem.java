
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import fr.erinagroups.erinium.init.EriniumModItems;

public class EriniumAxeItem extends AxeItem {
	public EriniumAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 11f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 30;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EriniumModItems.ERINIUM_INGOT.get()));
			}
		}, 1, -3.3f, new Item.Properties());
	}
}
