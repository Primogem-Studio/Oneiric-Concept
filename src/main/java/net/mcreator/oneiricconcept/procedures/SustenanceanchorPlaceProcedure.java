package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SustenanceanchorPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Direction wsen = Direction.NORTH;
		double nu = 0;
		double y1 = 0;
		if (!world.isClientSide()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 3, z))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(OneiricconceptModItems.SUSTENANCEANCHORITEM.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				WesnProcedure.execute(world, x, y, z, entity.getYRot());
				for (int index0 = 0; index0 < 100; index0++) {
					nu = nu + 2;
					OneiricconceptMod.queueServerWork((int) nu, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (x + 0.5), (y + 3), (z + 0.5), 10, 0.2, 0.6, 0.2, 0.1);
					});
				}
				OneiricconceptMod.queueServerWork(200, () -> {
					world.setBlock(BlockPos.containing(x, y + 2, z), OneiricconceptModBlocks.SUSTENANCEANCHOROFF.get().defaultBlockState(), 3);
				});
			}
		}
	}
}