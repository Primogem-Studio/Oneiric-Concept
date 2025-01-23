package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;

public class FishHealthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("oneiricconcept:fishs"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(),
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE, (entity.getX()), (entity.getY()), (entity.getZ()), 3, 0.5, 0.5, 0.5, 0.5);
			{
				final Vec3 _center = new Vec3(x, (y + 3), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getPersistentData().getBoolean("fishheart")) {
						if (RandomProcedure.execute(world, 0.9)) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
						entityiterator.push((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), 1, 3)), (Mth.nextDouble(RandomSource.create(), -1, 1)));
					}
				}
			}
		}
	}
}
