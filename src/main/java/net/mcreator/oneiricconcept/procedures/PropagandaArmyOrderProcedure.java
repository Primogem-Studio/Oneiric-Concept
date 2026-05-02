package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class PropagandaArmyOrderProcedure {
	public static void execute(LevelAccessor world, Entity entity, boolean is1, double exp, double nu, double sec) {
		if (entity == null)
			return;
		String txt = "";
		double Nu = 0;
		double NuE = 0;
		double ex = 0;
		double ey = 0;
		double ez = 0;
		ex = entity.getX();
		ey = entity.getY();
		ez = entity.getZ();
		if (hasEntityInInventory(entity, new ItemStack(OneiricconceptModItems.PROPAGANDA_ARMY.get())) || hasEntityInInventory(entity, new ItemStack(OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK.get()))) {
			for (int index0 = 0; index0 < (int) (exp / 10); index0++) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) exp);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, ex, ey, ez, new ItemStack(OneiricconceptModItems.HONKAI_SHARD.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (!world.isClientSide()) {
				Nu = nu;
				NuE = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).OrderNu;
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((sec + "" + (exp / 50 <= NuE ? "s|\u00A7a" : "s|\u00A74") + exp / 50 + "/" + NuE)), true);
				txt = Component.translatable(("translation.oneiricconcept.propaganda" + Mth.nextInt(RandomSource.create(), 1, 28))).getString();
				if (is1) {
					{
						OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
						_vars.OrderNu = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.propagandatip").getString())), false);
				}
				if (0 < sec) {
					if (Nu < NuE) {
						Nu = NuE;
						{
							OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
							_vars.orderMassage = txt;
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(txt), false);
						OneiricconceptMod.queueServerWork(20, () -> {
							PropagandaArmyOrderProcedure.execute(world, entity, false, exp, nu + 1, sec - 1);
						});
					} else {
						OneiricconceptMod.queueServerWork(20, () -> {
							PropagandaArmyOrderProcedure.execute(world, entity, false, exp, nu, sec - 1);
						});
					}
				} else {
					if (exp / 50 <= NuE) {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u4F60\u8FC7\u5173").withColor(0x00ff33), false);
						}
						for (int index1 = 0; index1 < (int) NuE; index1++) {
							if (entity instanceof Player _player)
								_player.giveExperiencePoints((int) exp);
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, ex, ey, ez, new ItemStack(OneiricconceptModItems.HONKAI_SHARD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u8BE5\u7F5A").withColor(0xff0000), false);
						}
						if (entity instanceof LivingEntity _entity) {
							DamageSource _dmgsource = new DamageSource(world.holderOrThrow(DamageTypes.GENERIC));
							_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
								@Override
								public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
									String _translatekey = "death.attack.propaganda";
									if (this.getEntity() == null && this.getDirectEntity() == null) {
										return _msgEntity.getKillCredit() != null
												? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
												: Component.translatable(_translatekey, _msgEntity.getDisplayName());
									} else {
										Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
										ItemStack _itemstack = ItemStack.EMPTY;
										if (this.getEntity() instanceof LivingEntity _livingentity)
											_itemstack = _livingentity.getMainHandItem();
										return !_itemstack.isEmpty() && _itemstack.get(DataComponents.CUSTOM_NAME) != null
												? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
												: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
									}
								}
							}, (float) ((exp / 50 - NuE) * 10));
						}
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}