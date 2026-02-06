package net.mcreator.oneiricconcept.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.procedures.PlusLantrenListorderProcedure;
import net.mcreator.oneiricconcept.procedures.MinusUIDLIstorderProcedure;
import net.mcreator.oneiricconcept.procedures.LanternSaveProcedure;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record GUIcelebratoryxiaolanternEditButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<GUIcelebratoryxiaolanternEditButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(OneiricconceptMod.MODID, "gu_icelebratoryxiaolantern_edit_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GUIcelebratoryxiaolanternEditButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GUIcelebratoryxiaolanternEditButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GUIcelebratoryxiaolanternEditButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GUIcelebratoryxiaolanternEditButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GUIcelebratoryxiaolanternEditButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MinusUIDLIstorderProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			PlusLantrenListorderProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			LanternSaveProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		OneiricconceptMod.addNetworkMessage(GUIcelebratoryxiaolanternEditButtonMessage.TYPE, GUIcelebratoryxiaolanternEditButtonMessage.STREAM_CODEC, GUIcelebratoryxiaolanternEditButtonMessage::handleData);
	}
}