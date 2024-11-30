
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.potion.B2sausageMobEffect;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, OneiricconceptMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> B_2SAUSAGE = REGISTRY.register("b_2sausage", () -> new B2sausageMobEffect());
}
