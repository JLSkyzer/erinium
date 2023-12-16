package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

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

import java.util.ArrayList;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class NetherMaintenanceProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"), File.separator + (entity.getDisplayName().getString() + ".json"));
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					JsonObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (JsonObject.get("staff.erinium.command").getAsBoolean() == true) {
						if (!EriniumModVariables.MapVariables.get(world).maintenanceNether) {
							EriniumModVariables.MapVariables.get(world).maintenanceNether = true;
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cMaintenance \u00A7aON"), false);
							if (world instanceof ServerLevel _origLevel) {
								LevelAccessor _worldorig = world;
								world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
								if (world != null) {
									for (Entity entityiterator : new ArrayList<>(world.players())) {
										if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
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
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cKicked because : maintenance"), false);
									}
								}
								world = _worldorig;
							}
						} else {
							EriniumModVariables.MapVariables.get(world).maintenanceNether = false;
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cMaintenance \u00A7aOFF"), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cVous n'avez pas la permission !"), false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
