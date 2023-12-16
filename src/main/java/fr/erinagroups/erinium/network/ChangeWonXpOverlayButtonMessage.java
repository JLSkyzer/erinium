
package fr.erinagroups.erinium.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import fr.erinagroups.erinium.world.inventory.ChangeWonXpOverlayMenu;
import fr.erinagroups.erinium.procedures.SetYProceduresProcedure;
import fr.erinagroups.erinium.procedures.SetXProceduresProcedure;
import fr.erinagroups.erinium.procedures.RankWonXpOverlayTestBtnProcedure;
import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangeWonXpOverlayButtonMessage {
	private final int buttonID, x, y, z;

	public ChangeWonXpOverlayButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ChangeWonXpOverlayButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ChangeWonXpOverlayButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ChangeWonXpOverlayButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = ChangeWonXpOverlayMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetXProceduresProcedure.execute(entity, guistate);
		}
		if (buttonID == 1) {

			SetYProceduresProcedure.execute(entity, guistate);
		}
		if (buttonID == 2) {

			RankWonXpOverlayTestBtnProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EriniumMod.addNetworkMessage(ChangeWonXpOverlayButtonMessage.class, ChangeWonXpOverlayButtonMessage::buffer, ChangeWonXpOverlayButtonMessage::new, ChangeWonXpOverlayButtonMessage::handler);
	}
}
