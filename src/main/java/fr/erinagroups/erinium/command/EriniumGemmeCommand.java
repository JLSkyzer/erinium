
package fr.erinagroups.erinium.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import fr.erinagroups.erinium.procedures.GemmeTakeProcedure;
import fr.erinagroups.erinium.procedures.GemmeSetProcedure;
import fr.erinagroups.erinium.procedures.GemmeResetProcedure;
import fr.erinagroups.erinium.procedures.GemmeGiveProcedure;
import fr.erinagroups.erinium.procedures.GemmeGetProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class EriniumGemmeCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("eriniumgemme").requires(s -> s.hasPermission(3))
				.then(Commands.argument("uuid", StringArgumentType.word()).then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					GemmeSetProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				}))).then(Commands.literal("give").then(Commands.argument("amount", DoubleArgumentType.doubleArg(1)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					GemmeGiveProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				}))).then(Commands.literal("take").then(Commands.argument("amount", DoubleArgumentType.doubleArg(1)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					GemmeTakeProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				}))).then(Commands.literal("reset").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					GemmeResetProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				})).then(Commands.literal("get").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					GemmeGetProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				}))));
	}
}
