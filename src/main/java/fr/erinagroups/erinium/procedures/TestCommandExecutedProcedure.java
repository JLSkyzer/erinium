package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class TestCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure TestCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack Item_1 = ItemStack.EMPTY;
		Item_1 = new ItemStack(Items.POTION);
		((Item_1)).setDisplayName(new StringTextComponent("Potion sans effet"));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = (Item_1);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		(Item_1).getOrCreateTag().putString("Potion", "minecraft:strong_strength");
		((Item_1)).setDisplayName(new StringTextComponent("Potion avec effet"));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = (Item_1);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
