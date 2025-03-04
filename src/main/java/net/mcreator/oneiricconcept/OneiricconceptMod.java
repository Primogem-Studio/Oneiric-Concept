package net.mcreator.oneiricconcept;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.oneiricconcept.world.features.StructureFeature;
import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModTabs;
import net.mcreator.oneiricconcept.init.OneiricconceptModSounds;
import net.mcreator.oneiricconcept.init.OneiricconceptModPotions;
import net.mcreator.oneiricconcept.init.OneiricconceptModParticleTypes;
import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.init.OneiricconceptModMenus;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModFluids;
import net.mcreator.oneiricconcept.init.OneiricconceptModFluidTypes;
import net.mcreator.oneiricconcept.init.OneiricconceptModFeatures;
import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlockEntities;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

@Mod("oneiricconcept")
public class OneiricconceptMod {
	public static final Logger LOGGER = LogManager.getLogger(OneiricconceptMod.class);
	public static final String MODID = "oneiricconcept";

	public OneiricconceptMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		OneiricconceptModSounds.REGISTRY.register(modEventBus);
		OneiricconceptModBlocks.REGISTRY.register(modEventBus);
		OneiricconceptModBlockEntities.REGISTRY.register(modEventBus);
		OneiricconceptModItems.REGISTRY.register(modEventBus);
		OneiricconceptModEntities.REGISTRY.register(modEventBus);
		OneiricconceptModTabs.REGISTRY.register(modEventBus);
		OneiricconceptModVariables.ATTACHMENT_TYPES.register(modEventBus);
		OneiricconceptModFeatures.REGISTRY.register(modEventBus);
		StructureFeature.REGISTRY.register(modEventBus);
		OneiricconceptModPotions.REGISTRY.register(modEventBus);
		OneiricconceptModMobEffects.REGISTRY.register(modEventBus);
		OneiricconceptModMenus.REGISTRY.register(modEventBus);
		OneiricconceptModParticleTypes.REGISTRY.register(modEventBus);
		OneiricconceptModFluids.REGISTRY.register(modEventBus);
		OneiricconceptModFluidTypes.REGISTRY.register(modEventBus);
		// Start of user code block mod init
		PGCApi.init();
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
