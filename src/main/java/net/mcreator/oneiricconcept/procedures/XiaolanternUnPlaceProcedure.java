package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Display;

import java.util.Comparator;

public class XiaolanternUnPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, (y + 1), z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Display.TextDisplay) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}