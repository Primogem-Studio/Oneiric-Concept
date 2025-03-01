package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class LaserProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double rangee = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double total_distance = 0;
		double steps = 0;
		double ratio = 0;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		world.addParticle(ParticleTypes.FLASH, x, y, z, 0, 0, 0);
		rangee = 20;
		x2 = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(rangee)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		y2 = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(rangee)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		z2 = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(rangee)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + world.getBlockState(BlockPos.containing(x2, y2, z2)))), false);
		dx = x2 - x;
		dy = y2 - y;
		dz = z2 - z;
		total_distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
		steps = total_distance / 0.1;
		for (int index0 = 0; index0 < (int) steps; index0++) {
			ratio = (index0 * 0.1) / total_distance;
			world.addParticle(ParticleTypes.FIREWORK, (x + ratio * dx), (y + ratio * dy), (z + ratio * dz), 0, 0, 0);
		}
		(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_PROJECTILE), immediatesourceentity, entity), 3);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
