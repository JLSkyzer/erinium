
package fr.erinagroups.erinium.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.procedures.GemmeTakeProcedure;
import fr.erinagroups.erinium.procedures.GemmeSetProcedure;
import fr.erinagroups.erinium.procedures.GemmeResetProcedure;
import fr.erinagroups.erinium.procedures.GemmeGiveProcedure;
import fr.erinagroups.erinium.procedures.GemmeGetProcedure;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;
import com.github.hexomod.worldeditcuife3.s;

@Mod.EventBusSubscriber
public class EriniumGemmeCommand {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(LiteralArgumentBuilder.<CommandSource>literal("eriniumgemme").requires(s -> s.hasPermissionLevel(3))
						.then(Commands.argument("uuid", StringArgumentType.word())
								.then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerWorld world = arguments.getSource().getWorld();
									double x = arguments.getSource().getPos().getX();
									double y = arguments.getSource().getPos().getY();
									double z = arguments.getSource().getPos().getZ();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getHorizontalFacing();

									GemmeSetProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
													new AbstractMap.SimpleEntry<>("arguments", arguments),
													new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									return 0;
								}))).then(Commands.literal("give")
										.then(Commands.argument("amount", DoubleArgumentType.doubleArg(1)).executes(arguments -> {
											ServerWorld world = arguments.getSource().getWorld();
											double x = arguments.getSource().getPos().getX();
											double y = arguments.getSource().getPos().getY();
											double z = arguments.getSource().getPos().getZ();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getHorizontalFacing();

											GemmeGiveProcedure.executeProcedure(Stream
													.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
															new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
															new AbstractMap.SimpleEntry<>("arguments", arguments),
															new AbstractMap.SimpleEntry<>("entity", entity))
													.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
											return 0;
										})))
								.then(Commands.literal("take")
										.then(Commands.argument("amount", DoubleArgumentType.doubleArg(1)).executes(arguments -> {
											ServerWorld world = arguments.getSource().getWorld();
											double x = arguments.getSource().getPos().getX();
											double y = arguments.getSource().getPos().getY();
											double z = arguments.getSource().getPos().getZ();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getHorizontalFacing();

											GemmeTakeProcedure.executeProcedure(Stream
													.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
															new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
															new AbstractMap.SimpleEntry<>("arguments", arguments),
															new AbstractMap.SimpleEntry<>("entity", entity))
													.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
											return 0;
										})))
								.then(Commands.literal("reset").executes(arguments -> {
									ServerWorld world = arguments.getSource().getWorld();
									double x = arguments.getSource().getPos().getX();
									double y = arguments.getSource().getPos().getY();
									double z = arguments.getSource().getPos().getZ();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getHorizontalFacing();

									GemmeResetProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
													new AbstractMap.SimpleEntry<>("arguments", arguments),
													new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									return 0;
								})).then(Commands.literal("get").executes(arguments -> {
									ServerWorld world = arguments.getSource().getWorld();
									double x = arguments.getSource().getPos().getX();
									double y = arguments.getSource().getPos().getY();
									double z = arguments.getSource().getPos().getZ();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getHorizontalFacing();

									GemmeGetProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
													new AbstractMap.SimpleEntry<>("arguments", arguments),
													new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									return 0;
								}))));
	}
}
