package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.Comparator;

public class LaserProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity target = null;
		boolean isGc = false;
		if (!world.isClientSide()) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
			if (target == null) {
				target = findEntityInWorldRange(world, Monster.class, x, y, z, 30);
			}
			isGc = ModList.get().isLoaded("genshincraft");
			LaserhurtProcedure.execute(world, entity.getX(), entity.getY() + entity.getBbHeight() / 2, entity.getZ(), entity, target,
					Math.max(isGc ? 32 : 2, (isGc ? 40 : 4) * JunHengDengJiProcedure.execute(target) * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER))));
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}