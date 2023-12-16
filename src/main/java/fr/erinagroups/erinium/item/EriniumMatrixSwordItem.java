
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import fr.erinagroups.erinium.init.EriniumModItems;

public class EriniumMatrixSwordItem extends SwordItem {
	public EriniumMatrixSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 3000;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 7f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 28;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EriniumModItems.ERINIUM_MATRIX_INGOT.get()));
			}
		}, 3, 96f, new Item.Properties());
	}
}
