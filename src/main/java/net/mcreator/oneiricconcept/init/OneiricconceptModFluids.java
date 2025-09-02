/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.oneiricconcept.fluid.MemoriaFluid;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, OneiricconceptMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> MEMORIA = REGISTRY.register("memoria", () -> new MemoriaFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MEMORIA = REGISTRY.register("flowing_memoria", () -> new MemoriaFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MEMORIA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MEMORIA.get(), RenderType.translucent());
		}
	}
}