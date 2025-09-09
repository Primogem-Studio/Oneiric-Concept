package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.Comparator;

public class LaserProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity target = null;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double total_distance = 0;
		double steps = 0;
		double ratio = 0;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		boolean isGc = false;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		x1 = entity.getX();
		y1 = entity.getY() + entity.getBbHeight() / 2;
		z1 = entity.getZ();
		if (target == null) {
			target = findEntityInWorldRange(world, Monster.class, x, y, z, 30);
		}
		if (target != null) {
			world.addParticle(ParticleTypes.FLASH, x, y, z, 0, 0, 0);
			x2 = target.getX();
			y2 = target.getY() + target.getBbHeight() / 2;
			z2 = target.getZ();
			dx = x2 - x1;
			dy = y2 - y1;
			dz = z2 - z1;
			total_distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
			steps = total_distance / 0.1;
			for (int index0 = 0; index0 < (int) steps; index0++) {
				ratio = (index0 * 0.1) / total_distance;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("particle minecraft:wax_off " + (x1 + ratio * dx) + (" " + (y1 + ratio * dy)) + (" " + (z1 + ratio * dz)) + " 0 0 0 1 1 force @a"));
			}
			isGc = ModList.get().isLoaded("genshincraft");
			target.hurt(TypeDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.MOB_PROJECTILE), immediatesourceentity, entity), false, true, true, 1),
					(float) Math.max(isGc ? 30 : 1, (isGc ? 30 : 2) * JunHengDengJiProcedure.execute(target) * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER))));
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}