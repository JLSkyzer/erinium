package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModItems;
import fr.erinagroups.erinium.init.EriniumModBlocks;

@Mod.EventBusSubscriber
public class OnCraftProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModBlocks.SPATIAL_TELEPORTER_BLOCK.get())) : false) {
			if (!((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl >= 5)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(EriniumModBlocks.SPATIAL_TELEPORTER_BLOCK.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EriniumModItems.PRINTED_CIRCUIT_BOARD.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EriniumModItems.DRANITE_GEM.get());
					_setstack.setCount(4);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EriniumModItems.WIRING_KIT.get());
					_setstack.setCount(4);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				ErrorDonthaveLevelProcedure.execute(entity);
			}
		} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.COBBLE_VOID.get())) : false) {
			if (!((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl >= 3)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(EriniumModItems.COBBLE_VOID.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.ENDER_EYE);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.LEATHER);
					_setstack.setCount(4);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				ErrorDonthaveLevelProcedure.execute(entity);
			}
		}
	}
}
