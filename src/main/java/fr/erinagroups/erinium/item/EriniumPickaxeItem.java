
package fr.erinagroups.erinium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import fr.erinagroups.erinium.init.EriniumModItems;

public class EriniumPickaxeItem extends PickaxeItem {
	public EriniumPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2000;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 2f;
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
		}, 1, -3f, new Item.Properties());
	}
}
