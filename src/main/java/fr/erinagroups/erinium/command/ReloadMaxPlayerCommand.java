
package fr.erinagroups.erinium.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.procedures.FqqProcedure;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;

@Mod.EventBusSubscriber
public class ReloadMaxPlayerCommand {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("reloadmaxplayer")

				.executes(arguments -> {
					ServerWorld world = arguments.getSource().getWorld();
					double x = arguments.getSource().getPos().getX();
					double y = arguments.getSource().getPos().getY();
					double z = arguments.getSource().getPos().getZ();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getHorizontalFacing();

					FqqProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return 0;
				}));
	}
}