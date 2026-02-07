package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

public class WeatherStatusUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean iscold = false;
		double wethermode = 0;
		if (RandomProcedure.execute(world, 0.01) && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "explosion")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 20, Level.ExplosionInteraction.NONE);
			PrimogemExplosionProcedure.execute(world, x, y, z);
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					{
						Entity _ent = entityiterator;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 2,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s primogemcraft:yiji 0 10");
						}
					}
				}
			}
			ExplosionIgnitesProcedure.execute(world, x, y, z, 0, 20);
		} else if (world.getLevelData().isRaining()) {
			wethermode = (world.getLevelData() instanceof ServerLevelData _levelData5 ? _levelData5.getRainTime() : 0) < 3600 ? 0 : 1;
		} else if (world instanceof Level _lvl6 && _lvl6.isDay()) {
			wethermode = (world.getLevelData() instanceof ServerLevelData _levelData7 ? _levelData7.getClearWeatherTime() : 0) < 3600 ? 1 : 0;
		}
		StormGlassParticleProcedure.execute(world, x, y, z, 20);
		{
			int _value = (int) wethermode;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}