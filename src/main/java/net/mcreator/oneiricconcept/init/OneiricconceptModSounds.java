
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, OneiricconceptMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> SURPRISE_BOX_FOR_GOOD_OR_BAD = REGISTRY.register("surprise_box_for_good_or_bad",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "surprise_box_for_good_or_bad")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MMM = REGISTRY.register("mmm", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "mmm")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BIGSTONECRUSHCHEST = REGISTRY.register("bigstonecrushchest", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "bigstonecrushchest")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOUYI = REGISTRY.register("houyi", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "houyi")));
}
