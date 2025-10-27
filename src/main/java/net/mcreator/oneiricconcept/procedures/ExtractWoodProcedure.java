package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ExtractWoodProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		sx = -20;
		for (int index0 = 0; index0 < 41; index0++) {
			sz = -20;
			for (int index1 = 0; index1 < 41; index1++) {
				block = (world.getBlockState(BlockPos.containing(x + sx, y, z + sz)));
				if (!(block.getBlock() == Blocks.AIR) && -1 != world.getBlockState(BlockPos.containing(x + sx, y, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y, z + sz))
						&& block.is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
					if (RandomProcedure.execute(world, 0.2)) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), (new ItemStack(block.getBlock())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), y, (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"particle minecraft:happy_villager ~ ~ ~ 0.5 0.5 0.5 1 10 force");
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_overworld"))) ? -63 : 0) < y) {
			OneiricconceptMod.queueServerWork(1, () -> {
				ExtractWoodProcedure.execute(world, x, y - 1, z, entity);
			});
		}
	}
}