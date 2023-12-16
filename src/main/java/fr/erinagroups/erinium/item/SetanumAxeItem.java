
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import fr.erinagroups.erinium.init.EriniumModItems;

public class SetanumAxeItem extends AxeItem {
	public SetanumAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2500;
			}

			public float getSpeed() {
				return 15f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 32;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EriniumModItems.SETANUM_INGOT.get()));
			}
		}, 1, -3f, new Item.Properties());
	}
}
