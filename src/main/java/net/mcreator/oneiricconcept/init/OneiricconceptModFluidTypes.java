/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.oneiricconcept.fluid.types.MemoriaFluidType;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, OneiricconceptMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> MEMORIA_TYPE = REGISTRY.register("memoria", () -> new MemoriaFluidType());
}