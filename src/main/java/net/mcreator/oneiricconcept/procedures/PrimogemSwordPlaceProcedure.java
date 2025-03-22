package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PrimogemSwordPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raintime = 0;
		double cleartime = 0;
		double timemmss = 0;
		boolean isexplosion = false;
		ItemStack handitem = ItemStack.EMPTY;
		ItemStack qgdysj = ItemStack.EMPTY;
		raintime = world.getLevelData() instanceof ServerLevelData _levelData0 ? _levelData0.getClearWeatherTime() : 0;
		cleartime = world.getLevelData() instanceof ServerLevelData _levelData1 ? _levelData1.getRainTime() : 0;
		handitem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		qgdysj = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:qgdysj")));
		isexplosion = getBlockNBTLogic(world, BlockPos.containing(x, y, z), "explosion");
		if (handitem.getItem() == qgdysj.getItem() && !isexplosion) {
			handitem.shrink(1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.RAID_OMEN, (x + 0.5), (y + 0.5), (z + 0.5), 50, 0.1, 0.1, 0.1, 1);
			isexplosion = true;
		} else if (entity.isShiftKeyDown() && isexplosion) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WAX_OFF, (x + 0.5), (y + 0.5), (z + 0.5), 50, 0.1, 0.1, 0.1, 1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), qgdysj);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			isexplosion = false;
		} else {
			timemmss = (raintime == 0 ? cleartime : raintime) / 20;
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						(Component.translatable((raintime == 0 ? "translation.oneiricconcept.weatherclear" : "translation.oneiricconcept.weatherrain")).getString() + "" + (int) Math.floor(timemmss / 60) + "\uFF1A" + (int) Math.floor(timemmss % 60))),
						false);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("explosion", isexplosion);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}
