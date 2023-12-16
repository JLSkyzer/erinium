
package fr.erinagroups.erinium.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;

import java.util.List;

import fr.erinagroups.erinium.procedures.GlobalArmorHelmetProcedure;
import fr.erinagroups.erinium.procedures.GlobalArmorBootsProcedure;
import fr.erinagroups.erinium.init.EriniumModItems;

public abstract class EriniumMatrixArmorItem extends ArmorItem {
	public EriniumMatrixArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 37;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{5, 6, 8, 5}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 28;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EriniumModItems.ERINIUM_MATRIX_INGOT.get()));
			}

			@Override
			public String getName() {
				return "erinium_matrix_armor";
			}

			@Override
			public float getToughness() {
				return 2.2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	public static class Helmet extends EriniumMatrixArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A7eEffet full armure : \u00A7bVitesse 2"));
			list.add(Component.literal("\u00A7eFull armor effect : \u00A7bSpeed 2"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/erinium_matrix_armor__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlobalArmorHelmetProcedure.execute(entity);
		}
	}

	public static class Chestplate extends EriniumMatrixArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A7eEffet full armure : \u00A7bVitesse 2"));
			list.add(Component.literal("\u00A7eFull armor effect : \u00A7bSpeed 2"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/erinium_matrix_armor__layer_1.png";
		}
	}

	public static class Leggings extends EriniumMatrixArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A7eEffet full armure : \u00A7bVitesse 2"));
			list.add(Component.literal("\u00A7eFull armor effect : \u00A7bSpeed 2"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/erinium_matrix_armor__layer_2.png";
		}
	}

	public static class Boots extends EriniumMatrixArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A7eEffet full armure : \u00A7bVitesse 2"));
			list.add(Component.literal("\u00A7eFull armor effect : \u00A7bSpeed 2"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "erinium:textures/models/armor/erinium_matrix_armor__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlobalArmorBootsProcedure.execute(entity);
		}
	}
}
