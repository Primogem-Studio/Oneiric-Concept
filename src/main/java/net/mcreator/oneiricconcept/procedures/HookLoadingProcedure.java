package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Comparator;
import java.util.Calendar;

public class HookLoadingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double EnchantLevel, double LoadingTime) {
		if (entity == null)
			return;
		Entity tmp = null;
		tmp = findEntityInWorldRange(world, FishingHook.class, x, y, z, 4);
		if (!(tmp == null)) {
			HookFallingProcedure.execute(world, x, y, z, tmp, entity, EnchantLevel, 0);
		} else {
			if (LoadingTime <= 20) {
				OneiricconceptMod.queueServerWork(1, () -> {
					HookLoadingProcedure.execute(world, x, y, z, entity, EnchantLevel, LoadingTime + 1);
				});
			} else if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u7B49\u5F85\u8D85\u65F6" + Calendar.getInstance().getTime().toString())), false);
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}