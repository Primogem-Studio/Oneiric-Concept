package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class EruditionExpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double exp = 0;
		double R_radius = 0;
		double D_delta_theta = 0;
		double T_theta = 0;
		double N_number = 0;
		double C_cycle = 0;
		if (!world.isClientSide()) {
			exp = entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0;
			BlockparticeProcedure.execute(world, x, y + 2.5, z, Blocks.LIGHT.defaultBlockState(), false, 0.01, 0.01, 0.01, 1, 0.01, "@p");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.PLAYERS, 5, 3);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.PLAYERS, 5, 3, false);
				}
			}
			N_number = 42;
			R_radius = 3;
			D_delta_theta = (2 * Math.PI) / N_number;
			for (int index0 = 0; index0 < (int) N_number; index0++) {
				T_theta = C_cycle * D_delta_theta;
				C_cycle = C_cycle + 1;
				ExporbProcedure.execute(world, x + R_radius * Math.sin(T_theta), y, z + R_radius * Math.cos(T_theta), Math.min(Math.ceil(exp / 42), 17));
			}
		}
	}
}