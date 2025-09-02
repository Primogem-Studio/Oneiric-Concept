package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.Comparator;

public class KillLanternProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double nui = 0;
		ItemStack itmstk = ItemStack.EMPTY;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(99 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entityiterator.getType()).toString()).equals("primogemcraft:xiaodeng")) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
					nui = 1 + nui;
				}
			}
		}
		itmstk = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:xiaodengwupin")));
		itmstk.setCount((int) nui);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, (1 + y), z, itmstk);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == OneiricconceptModBlocks.XIAO_LANTERN_RECYCLER.get()) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.kill").getString() + "" + new java.text.DecimalFormat("##.##").format(nui))), true);
	}
}