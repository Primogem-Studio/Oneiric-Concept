package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class WarmheartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String block = "";
		double fis = 0;
		BlockState upblock = Blocks.AIR.defaultBlockState();
		fis = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("fish");
		{
			final String _tagName = "fish";
			final double _tagValue = (fis + 0.01);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (entity.isInWater() && Math.random() < fis) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
				{
					final String _tagName = "fish";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.TROPICAL_FISH.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		block = BuiltInRegistries.BLOCK.getKey(blockstate.getBlock()).toString();
		if (block.contains("coral")) {
			block = block.replace("dead_", "");
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = BuiltInRegistries.BLOCK.get(ResourceLocation.parse((block).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (block.contains("block") && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER) {
				if (Math.random() < 0.2) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((block.replace("_block", ""))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
			}
		}
	}
}
