
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.world.features.SweetFlowersFeature;
import net.mcreator.oneiricconcept.world.features.CaveSweetFlowersFeature;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, OneiricconceptMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> SWEET_FLOWERS = REGISTRY.register("sweet_flowers", SweetFlowersFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CAVE_SWEET_FLOWERS = REGISTRY.register("cave_sweet_flowers", CaveSweetFlowersFeature::new);
}
