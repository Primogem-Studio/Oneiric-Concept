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
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class PropagandaArmyOrderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, boolean is1, double exp, double nu, double sec) {
		if (entity == null)
			return;
		String txt = "";
		double Nu = 0;
		double NuE = 0;
		double TXTNU = 0;
		if (hasEntityInInventory(entity, new ItemStack(OneiricconceptModItems.PROPAGANDA_ARMY.get()))) {
			for (int index0 = 0; index0 < (int) (exp / 20); index0++) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) exp);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(OneiricconceptModItems.HONKAI_SHARD.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (!world.isClientSide()) {
				Nu = nu;
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((sec + "s")), true);
				TXTNU = Mth.nextInt(RandomSource.create(), 0, 4);
				if (TXTNU < 1) {
					txt = TXTNU < 0 ? "\u4E00\u751F\u53EA\u7231\u706B\u82B1\u82B1\uFF0C\u53D8\u5FC3\u4E00\u5B9A\u906D\u96F7\u5288\uFF01" : "\u809A\u76AE\u9971\u9971\u5FC3\u60C5\u597D\uFF0C\u770B\u706B\u82B1\u82B1\u770B\u5230\u8001\uFF01";
				} else if (TXTNU < 3) {
					txt = TXTNU < 2 ? "\u706B\u82B1\u82B1\uFF01\u706B\u82B1\u82B1\uFF01" : "\u72C2\u6B22\u76F4\u5230\u4E16\u754C\u5C3D\u5934\uFF01";
				} else {
					txt = "\u706B\u82B1\u82B1\u597D\u597D\u597D";
				}
				if (is1) {
					{
						OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
						_vars.OrderNu = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.propagandatip").getString())), false);
				}
				NuE = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).OrderNu;
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
							PropagandaArmyOrderProcedure.execute(world, x, y, z, entity, false, exp, nu + 1, sec - 1);
						});
					} else {
						OneiricconceptMod.queueServerWork(20, () -> {
							PropagandaArmyOrderProcedure.execute(world, x, y, z, entity, false, exp, nu, sec - 1);
						});
					}
				} else {
					if (exp / 50 < NuE) {
						for (int index1 = 0; index1 < (int) NuE; index1++) {
							if (entity instanceof Player _player)
								_player.giveExperiencePoints((int) exp);
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(OneiricconceptModItems.HONKAI_SHARD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else {
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