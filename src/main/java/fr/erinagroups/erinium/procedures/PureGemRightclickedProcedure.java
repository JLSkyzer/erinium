package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.item.PureGemItem;
import fr.erinagroups.erinium.item.GemXpItem;
import fr.erinagroups.erinium.item.GemTeleportItem;
import fr.erinagroups.erinium.item.GemRegenerationItem;
import fr.erinagroups.erinium.item.GemInvisibilityItem;
import fr.erinagroups.erinium.item.GemHealItem;
import fr.erinagroups.erinium.item.GemDamageItem;
import fr.erinagroups.erinium.item.GemCreditItem;
import fr.erinagroups.erinium.EriniumMod;

public class PureGemRightclickedProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure PureGemRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == PureGemItem.block) {
			random = (MathHelper.nextInt(new Random(), 1, 7));
			if (random == 1) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemInvisibilityItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemInvisibilityItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 2) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemTeleportItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemTeleportItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 3) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemHealItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemHealItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 4) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemRegenerationItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemRegenerationItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 5) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemDamageItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemDamageItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 6) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemXpItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemXpItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			} else if (random == 7) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(GemCreditItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + ""
									+ new ItemStack(GemCreditItem.block).getDisplayName().getString() + "\u00A7e\"")), (false));
				}
			}
		}
	}
}
