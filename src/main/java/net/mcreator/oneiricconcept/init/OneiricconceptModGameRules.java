
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> OCINITIALLOAD;
	public static GameRules.Key<GameRules.IntegerValue> OC_DAMAGEMULTIPLIER;
	public static GameRules.Key<GameRules.IntegerValue> OC_HEALTHMULTIPLIER;
	public static GameRules.Key<GameRules.BooleanValue> OCDEBUG;
	public static GameRules.Key<GameRules.BooleanValue> OCFLY;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		OCINITIALLOAD = GameRules.register("ocinitialload", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		OC_DAMAGEMULTIPLIER = GameRules.register("ocDamagemultiplier", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
		OC_HEALTHMULTIPLIER = GameRules.register("ocHealthmultiplier", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
		OCDEBUG = GameRules.register("ocdebug", GameRules.Category.CHAT, GameRules.BooleanValue.create(false));
		OCFLY = GameRules.register("ocfly", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
