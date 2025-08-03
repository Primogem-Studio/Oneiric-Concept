package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class XuanyuanArrowriseProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double yspd = 0;
		yspd = immediatesourceentity.getDeltaMovement().y();
		immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), (yspd + 0.2), (immediatesourceentity.getDeltaMovement().z())));
		if (10 < yspd) {
			if (world.dayTime() >= 24000) {
				FallingSunProcedure.execute(world);
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable("translation.oneiricconcept.fallingsun").getString())), false);
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			} else {
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u4E0D\u8981\u5728\u9152\u5427\u70B9\u7092\u996D\uFF01\uFF08\u4E16\u754C\u65F6\u95F4<24000tick\uFF09"), false);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(OneiricconceptModItems.XUANYUAN_ARROW.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}