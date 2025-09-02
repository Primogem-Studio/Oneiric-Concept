package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class GetPhaseTextProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String txt = "";
		if (IsNightProcedure.execute(world) && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_overworld")))
				&& !(world.getLevelData().isRaining() || world.getLevelData().isThundering()) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			txt = GetPhaseProcedure.execute(world) + "\uFF081~5\uFF09";
		} else {
			txt = "-";
		}
		return Component.translatable("translation.oneiricconcept.phaselevel").getString() + "" + txt;
	}
}