package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class ExplodeBoomBlossomsNoLoadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double rx = 0;
		double rz = 0;
		double mode = 0;
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, (y + 2), z, 3, Level.ExplosionInteraction.TNT);
		if (OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get() == blockstate.getBlock()) {
			mode = 0;
		} else if (OneiricconceptModBlocks.BOOM_BLOSSOMS_CRYO.get() == blockstate.getBlock()) {
			RangeDamageProcedure.execute(world, x, y, z, new DamageSource(world.holderOrThrow(DamageTypes.FREEZE)), 20, 21);
			mode = 2;
		} else if (OneiricconceptModBlocks.BOOM_BLOSSOMS_DENDRO.get() == blockstate.getBlock()) {
			mode = 3;
			RangeDamageProcedure.execute(world, x, y, z, new DamageSource(world.holderOrThrow(DamageTypes.WITHER)), 20, 21);
		} else if (OneiricconceptModBlocks.BOOM_BLOSSOMS_HYDRO.get() == blockstate.getBlock()) {
			mode = 1;
			RangeDamageProcedure.execute(world, x, y, z, new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 20, 21);
		} else if (OneiricconceptModBlocks.BOOM_BLOSSOMS_ELECTRO.get() == blockstate.getBlock()) {
			RangeDamageProcedure.execute(world, x, y, z, new DamageSource(world.holderOrThrow(DamageTypes.LIGHTNING_BOLT)), 20, 21);
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 5, 10); index0++) {
				rx = x + Mth.nextInt(RandomSource.create(), -10, 10);
				rz = z + Mth.nextInt(RandomSource.create(), -10, 10);
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(rx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) rx, (int) rz), rz)));;
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		ExplosionIgnitesProcedure.execute(world, x, y, z, mode, 21);
	}
}