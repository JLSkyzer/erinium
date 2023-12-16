package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.ArrayList;

import java.io.File;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.google.gson.JsonObject;

public class ListplayerCmdProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		File file = new File("");
		boolean allowed = false;
		double List = 0;
		{
			double _setval = 600;
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.list_player_cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7eListe des joueurs :"), false);
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\u260E] \u00A7aLobby : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\uD83C\uDFF9] \u00A7aFaction Alpha : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\uD83C\uDFF9] \u00A7aFaction Beta : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\uD83C\uDFF9] \u00A7aFaction Charlie : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\u26CF] \u00A7aMinage01 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\u26CF] \u00A7aMinage02 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")));
			if (world != null) {
				List = 0;
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					List = List + 1;
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77[\u26CF] \u00A7aMinage03 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))), false);
			}
			world = _worldorig;
		}
	}
}
