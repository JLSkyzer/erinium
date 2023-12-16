
package fr.erinagroups.erinium.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;

import fr.erinagroups.erinium.procedures.GlobalArmorHelmetProcedure;
import fr.erinagroups.erinium.procedures.GlobalArmorBootsProcedure;
import fr.erinagroups.erinium.init.EriniumModItems;

public abstract class SetanumItem extends ArmorItem {
	public SetanumItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 33;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{3, 5, 6, 3}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 20;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EriniumModItems.SETANUM_INGOT.get()));
			}

			@Override
			public String getName() {
				return "setanum";
			}

			@Override
			public float getToughness() {
				return 1.7f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	public static class Helmet extends SetanumItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/setanum__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlobalArmorHelmetProcedure.execute(entity);
		}
	}

	public static class Chestplate extends SetanumItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/setanum__layer_1.png";
		}
	}

	public static class Leggings extends SetanumItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/setanum__layer_2.png";
		}
	}

	public static class Boots extends SetanumItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/setanum__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlobalArmorBootsProcedure.execute(entity);
		}
	}
}
