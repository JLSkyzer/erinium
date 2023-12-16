
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import fr.erinagroups.erinium.init.EriniumModItems;

public class SetanumSwordItem extends SwordItem {
	public SetanumSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2500;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 6.8f;
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
		}, 3, 96f, new Item.Properties());
	}
}
