package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class ShatteringCutAatreeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sz = 0;
		double ent = 0;
		MaraRangeClearProcedure.execute(world, x, y, z, 67);
		for (int index0 = 0; index0 < 3; index0++) {
			sx = x + Mth.nextInt(RandomSource.create(), -2, 2);
			sz = z + Mth.nextInt(RandomSource.create(), -2, 2);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(sx, y, sz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/fill ~-1 -64 ~-1 ~1 319 ~1 air replace oneiricconcept:ambrosial_arbor_leave");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(sx, y, sz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/fill ~-1 -64 ~-1 ~1 319 ~1 air replace oneiricconcept:ambrosial_arbor_log");
		}
		{
			final Vec3 _center = new Vec3(x, 250, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("oneiricconcept:divinearrow")))) {
					ent = ent + 1;
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, (y + 10), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.push((Mth.nextDouble(RandomSource.create(), -3, 3)), 3, (Mth.nextDouble(RandomSource.create(), -3, 3)));
			}
		}
		if (ent < 60) {
			DivineArrowProcedure.execute(world, x, y, z);
		}
	}
}
