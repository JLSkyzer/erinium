package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.init.EriniumModItems;

public class KnifeLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.EMPTY_LARGE_BOTTLE.get())) : false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(EriniumModItems.EMPTY_LARGE_BOTTLE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EriniumModItems.BLOOD_LARGE_BOTTLE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
