package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.init.EriniumModItems;

@Mod.EventBusSubscriber
public class PureGemRightclickedProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EriniumModItems.PURE_GEM.get()) {
			random = Mth.nextInt(RandomSource.create(), 1, 7);
			if (random == 1) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_INVISIBILITY.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_INVISIBILITY.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 2) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_TELEPORT.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_TELEPORT.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 3) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_HEAL.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_HEAL.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 4) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_REGENERATION.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_REGENERATION.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 5) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_DAMAGE.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_DAMAGE.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 6) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_XP.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_XP.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			} else if (random == 7) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EriniumModItems.GEM_CREDIT.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium\u00A74] \u00A7aGG ! \u00A7eyou got a \"" + "" + new ItemStack(EriniumModItems.GEM_CREDIT.get()).getDisplayName().getString() + "\u00A7e\"")), false);
			}
		}
	}
}
