
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.potion.OcHungerMobEffect;
import net.mcreator.oneiricconcept.potion.EnergyMobEffect;
import net.mcreator.oneiricconcept.potion.CamoeffectMobEffect;
import net.mcreator.oneiricconcept.potion.B2sausageMobEffect;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, OneiricconceptMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> B_2SAUSAGE = REGISTRY.register("b_2sausage", () -> new B2sausageMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> OC_HUNGER = REGISTRY.register("oc_hunger", () -> new OcHungerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CAMO = REGISTRY.register("camo", () -> new CamoeffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ENERGY = REGISTRY.register("energy", () -> new EnergyMobEffect());
}
