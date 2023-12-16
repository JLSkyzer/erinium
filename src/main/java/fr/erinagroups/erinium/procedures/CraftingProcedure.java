package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.network.EriniumModVariables;

@Mod.EventBusSubscriber
public class CraftingProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity(), event.getCrafting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double crafted = 0;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if (itemstack.getItem() == Items.BREAD) {
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 100;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7a+" + 100 + " xp ";
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
							+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 60;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_overlay_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				RankLevelUpProcedure.execute(entity);
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
				if (itemstack.getItem() == Items.BREAD) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 120;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + 120 + " xp ";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
								+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_overlay_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					RankLevelUpProcedure.execute(entity);
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
					if (itemstack.getItem() == Items.BREAD) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 150;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + 150 + " xp ";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
									+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_overlay_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						RankLevelUpProcedure.execute(entity);
					}
				}
			}
		}
	}
}
