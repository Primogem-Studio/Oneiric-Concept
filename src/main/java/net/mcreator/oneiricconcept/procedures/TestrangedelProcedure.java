package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Comparator;

public class TestrangedelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double mode = 0;
		BlockState blocksae = Blocks.AIR.defaultBlockState();
		mode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("textures");
		OneiricconceptMod.LOGGER.warn((entity + "\u4F7F\u7528\u4E86\u4ED9\u529B\u79D2\u4EBA\u9524\uFF0C\u6A21\u5F0F" + mode));
		if (1 == mode) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator instanceof Player)) {
						TestDeleteProcedure.execute(world, x, y, z, entityiterator, entity);
					}
				}
			}
		} else if (2 == mode) {
			PrimogemExplosionProcedure.execute(world, x, y - 22, z);
		} else if (3 == mode) {
			blocksae = (world.getBlockState(
					new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(111)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(111)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
							entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(111)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((blocksae + "\n" + getDirectionFromBlockState(blocksae))), false);
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}