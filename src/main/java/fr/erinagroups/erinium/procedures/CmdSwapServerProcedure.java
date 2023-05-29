package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumMod;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class CmdSwapServerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				EriniumMod.LOGGER.warn("Failed to load dependency arguments for procedure CmdSwapServer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure CmdSwapServer!");
			return;
		}
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		File file = new File("");
		file = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"),
				File.separator + (entity.getDisplayName().getString() + ".json"));
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
						if ((StringArgumentType.getString(arguments, "serverid")).equals("alpha")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_alpha"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:faction_alpha"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("beta")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_beta"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:faction_beta"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("charlie")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_charlie"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:faction_charlie"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("minage01")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_01"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:minage_01"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("minage02")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_02"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:minage_02"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("minage03")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_03"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:minage_03"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else if ((StringArgumentType.getString(arguments, "serverid")).equals("nether")) {
							if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:erinium_nether"))))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:erinium_nether"));
										ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
										if (nextWorld != null) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
											((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
													nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
													_ent.rotationPitch);
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
											for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
											}
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("alpha, beta, charlie, minage01, minage02, minage03, nether"), (false));
							}
						}
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cVous n'avez pas la permission !"), (false));
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
