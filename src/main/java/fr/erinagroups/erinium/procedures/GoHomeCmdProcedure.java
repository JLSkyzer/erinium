package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class GoHomeCmdProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).inPvpMode == false) {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).HomeCmdCooldown == 0) {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x != 0
						&& (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y != 0
						&& (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z != 0) {
					if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).Home_dim).equals("Overworld")) {
						if (!((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD)) {
							if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = Level.OVERWORLD;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							{
								Entity _ent = entity;
								_ent.teleportTo(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x),
										((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y),
										((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x),
											((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y),
											((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z), _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aWelcome house !"), false);
						} else {
							{
								Entity _ent = entity;
								_ent.teleportTo(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x),
										((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y),
										((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x),
											((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y),
											((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z), _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aWelcome house !"), false);
						}
					}
				} else {
					if (!((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD)) {
						if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = Level.OVERWORLD;
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn()), (world.getLevelData().getZSpawn()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn()), (world.getLevelData().getZSpawn()), _ent.getYRot(), _ent.getXRot());
						}
					} else {
						{
							Entity _ent = entity;
							_ent.teleportTo((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn()), (world.getLevelData().getZSpawn()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn()), (world.getLevelData().getZSpawn()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				{
					double _setval = 100;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HomeCmdCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("\u00A7cWait " + Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).HomeCmdCooldown / 20) + " seconds !")), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cError: Vous ne pouvez pas faire cela car vous \u00EAtes en mode &acombat."), false);
		}
	}
}
