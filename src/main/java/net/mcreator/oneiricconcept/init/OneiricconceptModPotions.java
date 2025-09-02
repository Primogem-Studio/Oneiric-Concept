/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, OneiricconceptMod.MODID);
	public static final DeferredHolder<Potion, Potion> HUNGER_POTION = REGISTRY.register("hunger_potion", () -> new Potion(new MobEffectInstance(OneiricconceptModMobEffects.OC_HUNGER, 3600, 0, false, true)));
}