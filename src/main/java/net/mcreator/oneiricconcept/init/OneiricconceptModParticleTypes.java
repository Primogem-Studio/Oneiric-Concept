/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, OneiricconceptMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AMBROSIAL_ARBOR_FIRE = REGISTRY.register("ambrosial_arbor_fire", () -> new SimpleParticleType(true));
}