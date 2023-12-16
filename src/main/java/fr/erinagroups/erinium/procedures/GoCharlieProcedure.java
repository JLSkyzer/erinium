package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class GoCharlieProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double List = 0;
		if (!EriniumModVariables.MapVariables.get(world).maintenanceCharlie) {
			if (!((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element"))))) {
				if (world instanceof ServerLevel _origLevel) {
					LevelAccessor _worldorig = world;
					world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
					if (world != null) {
						List = 0;
						for (Entity entityiterator : new ArrayList<>(world.players())) {
							List = List + 1;
						}
						if (!(entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).vip) {
							if (List < EriniumModVariables.MapVariables.get(world).MaxPlayerPerServer) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7aTeleportatioooon"), false);
								if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element"));
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
									_ent.teleportTo(EriniumModVariables.MapVariables.get(world).charlie_x, EriniumModVariables.MapVariables.get(world).charlie_y, EriniumModVariables.MapVariables.get(world).charlie_z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(EriniumModVariables.MapVariables.get(world).charlie_x, EriniumModVariables.MapVariables.get(world).charlie_y, EriniumModVariables.MapVariables.get(world).charlie_z,
												_ent.getYRot(), _ent.getXRot());
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cErreur : serveur complet ! attendez que le serveur se vide ou acheter un grade vip"), false);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aTeleportatioooon"), false);
							if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element"));
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
								_ent.teleportTo(EriniumModVariables.MapVariables.get(world).charlie_x, EriniumModVariables.MapVariables.get(world).charlie_y, EriniumModVariables.MapVariables.get(world).charlie_z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(EriniumModVariables.MapVariables.get(world).charlie_x, EriniumModVariables.MapVariables.get(world).charlie_y, EriniumModVariables.MapVariables.get(world).charlie_z, _ent.getYRot(),
											_ent.getXRot());
							}
						}
					}
					world = _worldorig;
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cErreur : vous \u00EAtes d\u00E9j\u00E0 dans le serveur !"), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cErreur : serveur en \u00A76maintenance"), false);
		}
	}
}
