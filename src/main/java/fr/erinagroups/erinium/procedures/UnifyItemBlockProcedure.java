package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.item.LeadIngotItem;
import fr.erinagroups.erinium.item.CopperIngotItem;
import fr.erinagroups.erinium.block.LeadOreBlock;
import fr.erinagroups.erinium.block.CopperOreBlock;
import fr.erinagroups.erinium.EriniumMod;

public class UnifyItemBlockProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure UnifyItemBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure UnifyItemBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double count = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ores/copper")).contains(itemstackiterator.getItem())
							&& !(itemstackiterator.getItem() == CopperOreBlock.block.asItem())) {
						count = ((itemstackiterator).getCount());
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = itemstackiterator;
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CopperOreBlock.block);
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aUnification termin\u00A7e"), (true));
						}
					} else if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/copper")).contains(itemstackiterator.getItem())
							&& !(itemstackiterator.getItem() == CopperIngotItem.block)) {
						count = ((itemstackiterator).getCount());
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = itemstackiterator;
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CopperIngotItem.block);
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aUnification termin\u00A7e"), (true));
						}
					} else if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ores/lead")).contains(itemstackiterator.getItem())
							&& !(itemstackiterator.getItem() == LeadOreBlock.block.asItem())) {
						count = ((itemstackiterator).getCount());
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = itemstackiterator;
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(LeadOreBlock.block);
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aUnification termin\u00A7e"), (true));
						}
					} else if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/lead")).contains(itemstackiterator.getItem())
							&& !(itemstackiterator.getItem() == LeadIngotItem.block)) {
						count = ((itemstackiterator).getCount());
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = itemstackiterator;
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(LeadIngotItem.block);
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aUnification termin\u00A7e"), (true));
						}
					}
				}
			}
		}
	}
}
