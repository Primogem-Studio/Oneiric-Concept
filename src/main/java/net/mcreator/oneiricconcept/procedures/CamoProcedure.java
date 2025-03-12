package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Comparator;

public class CamoProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String debugtxt = "";
		double foloowrange = 0;
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entity == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					foloowrange = entityiterator instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE) ? _livingEntity5.getAttribute(Attributes.FOLLOW_RANGE).getBaseValue() : 0;
					if (-7 != foloowrange) {
						EntrestartfollowProcedure.execute(world, entityiterator, foloowrange);
					}
					if (entityiterator instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
						_livingEntity6.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue((-7));
					debugtxt = debugtxt + "" + entityiterator;
					if (entityiterator instanceof Mob _entity && null instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					if (entityiterator instanceof Mob _entity)
						_entity.getNavigation().stop();
				}
			}
		}
		if (entity.isAlive() && entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(OneiricconceptModMobEffects.CAMO)) {
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + debugtxt)), false);
			}
			OneiricconceptMod.queueServerWork(20, () -> {
				CamoProcedure.execute(world, entity);
			});
		}
	}
}
