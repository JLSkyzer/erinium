package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class UpgradeLvlProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure UpgradeLvl!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).xpFarmer >= 50000) {
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).xpFarmer - 50000);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xpFarmer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).lvlFarmer + 1);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lvlFarmer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("\u00A74[\u00A7eFarmer\u00A74] \u00A7bVous avez augmenter de un niveau ! Vous \u00EAtes niveau \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlFarmer))),
							(false));
				}
			} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent(("\u00A74[\u00A7eFarmer\u00A74] \u00A7bYou have leveled up! You are level \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlFarmer))),
							(false));
				}
			}
		} else if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).xpHunter >= 50000) {
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).xpHunter - 50000);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xpHunter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).lvlHunter + 1);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lvlHunter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("\u00A74[\u00A7eHunter\u00A74] \u00A7bVous avez augmenter de un niveau ! Vous \u00EAtes niveau \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlHunter))),
							(false));
				}
			} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent(("\u00A74[\u00A7eHunter\u00A74] \u00A7bYou have leveled up! You are level \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlHunter))),
							(false));
				}
			}
		} else if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).xpMiner >= 50000) {
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).xpMiner - 50000);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xpMiner = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).lvlMiner + 1);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lvlMiner = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("\u00A74[\u00A7eMiner\u00A74] \u00A7bVous avez augmenter de un niveau ! Vous \u00EAtes niveau \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlMiner))),
							(false));
				}
			} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent(("\u00A74[\u00A7eMiner\u00A74] \u00A7bYou have leveled up! You are level \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlMiner))),
							(false));
				}
			}
		} else if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).xpAlchimiste >= 50000) {
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).xpAlchimiste - 50000);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xpAlchimiste = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).lvlAlchimiste + 1);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lvlAlchimiste = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("\u00A74[\u00A7eAlchimiste\u00A74] \u00A7bVous avez augmenter de un niveau ! Vous \u00EAtes niveau \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlAlchimiste))),
							(false));
				}
			} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent(("\u00A74[\u00A7eAlchimist\u00A74] \u00A7bYou have leveled up! You are level \u00A7a"
									+ Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).lvlAlchimiste))),
							(false));
				}
			}
		}
	}
}
