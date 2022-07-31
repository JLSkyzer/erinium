
package fr.erinagroups.erinium.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class SpaceBreathingEnchantment extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:space_breathing")
	public static final Enchantment enchantment = null;

	public SpaceBreathingEnchantment(EriniumModElements instance) {
		super(instance, 376);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("space_breathing"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR_HEAD, slots);
		}

		@Override
		public int getMinLevel() {
			return 0;
		}

		@Override
		public int getMaxLevel() {
			return 0;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
