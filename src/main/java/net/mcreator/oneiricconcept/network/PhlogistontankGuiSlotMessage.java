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

import net.mcreator.oneiricconcept.procedures.TankAddLvaTagProcedure;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record PhlogistontankGuiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<PhlogistontankGuiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(OneiricconceptMod.MODID, "phlogistontank_gui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PhlogistontankGuiSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PhlogistontankGuiSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new PhlogistontankGuiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PhlogistontankGuiSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final PhlogistontankGuiSlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 0) {

			TankAddLvaTagProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		OneiricconceptMod.addNetworkMessage(PhlogistontankGuiSlotMessage.TYPE, PhlogistontankGuiSlotMessage.STREAM_CODEC, PhlogistontankGuiSlotMessage::handleData);
	}
}