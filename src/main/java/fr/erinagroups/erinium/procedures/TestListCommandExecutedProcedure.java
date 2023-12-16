package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.ArrayList;

public class TestListCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		List<Object> test = new ArrayList<>();
		test.clear();
		test.add("Alpha");
		test.add("Beta");
		test.add("Charlie");
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + test)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("The size : " + test.size())), false);
	}
}
