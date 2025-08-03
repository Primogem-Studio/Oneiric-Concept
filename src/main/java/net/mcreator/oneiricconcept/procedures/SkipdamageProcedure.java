package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SkipdamageProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack, double indexx) {
		if (entity == null)
			return;
		ItemStack zpitem = ItemStack.EMPTY;
		double ktime = 0;
		if (0 < (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0)) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 0.5));
		} else if (0 < (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0)) {
			if (entity instanceof Player _player)
				_player.causeFoodExhaustion((float) 0.5);
		} else if (entity.isAlive()) {
			entity.invulnerableTime = 0;
			if (entity instanceof LivingEntity _entity) {
				DamageSource _dmgsource = new DamageSource(world.holderOrThrow(DamageTypes.GENERIC));
				_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
					@Override
					public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
						String _translatekey = "death.attack.skip";
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
				}, (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)));
			}
		}
		if (0 < indexx) {
			OneiricconceptMod.queueServerWork(1, () -> {
				SkipdamageProcedure.execute(world, entity, itemstack, indexx - 1);
			});
		} else {
			entity.invulnerableTime = 10;
		}
	}
}