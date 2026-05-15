package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class ItemTpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double range) {
		if (entity == null)
			return;
		double xx = 0;
		double zz = 0;
		double rang = 0;
		ItemStack items = ItemStack.EMPTY;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((2 * range) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof ItemEntity) {
					items = (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY);
					if (entity instanceof Player _player) {
						ItemStack _setstack = items.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}