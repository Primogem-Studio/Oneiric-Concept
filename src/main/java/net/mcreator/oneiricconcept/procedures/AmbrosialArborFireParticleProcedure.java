package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class AmbrosialArborFireParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 0, 80), () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + 1), (z + Mth.nextDouble(RandomSource.create(), 0, 1))), Vec2.ZERO,
							_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle oneiricconcept:ambrosial_arbor_fire ~ ~1 ~ 0.3 0.3 0.3 0.8 1 force");
			});
		}
	}
}