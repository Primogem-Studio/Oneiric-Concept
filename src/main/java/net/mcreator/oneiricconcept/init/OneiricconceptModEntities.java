
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.entity.XuanyuanSwordQEntity;
import net.mcreator.oneiricconcept.entity.XuanyuanQ2Entity;
import net.mcreator.oneiricconcept.entity.XuanYuanArrowArrowEntity;
import net.mcreator.oneiricconcept.entity.SkyShatteringLuxArrowEntity;
import net.mcreator.oneiricconcept.entity.OnLaserEntity;
import net.mcreator.oneiricconcept.entity.MoraCoinEntity;
import net.mcreator.oneiricconcept.entity.InvalidEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveEntity;
import net.mcreator.oneiricconcept.entity.EngineeringAntimatterBombEntity;
import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;
import net.mcreator.oneiricconcept.entity.BaryonEntity;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, OneiricconceptMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<XuanyuanSwordQEntity>> XUANYUAN_SWORD_Q = register("xuanyuan_sword_q",
			EntityType.Builder.<XuanyuanSwordQEntity>of(XuanyuanSwordQEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<XuanyuanQ2Entity>> XUANYUAN_Q_2 = register("xuanyuan_q_2",
			EntityType.Builder.<XuanyuanQ2Entity>of(XuanyuanQ2Entity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrystalTurtleEntity>> CRYSTAL_TURTLE = register("crystal_turtle",
			EntityType.Builder.<CrystalTurtleEntity>of(CrystalTurtleEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<MoraCoinEntity>> MORA_COIN = register("mora_coin",
			EntityType.Builder.<MoraCoinEntity>of(MoraCoinEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<InvalidEntity>> INVALID = register("invalid",
			EntityType.Builder.<InvalidEntity>of(InvalidEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0f, 0f));
	public static final DeferredHolder<EntityType<?>, EntityType<SkyShatteringLuxArrowEntity>> SKY_SHATTERING_LUX_ARROW = register("sky_shattering_lux_arrow",
			EntityType.Builder.<SkyShatteringLuxArrowEntity>of(SkyShatteringLuxArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ExplosiveEntity>> EXPLOSIVE = register("explosive",
			EntityType.Builder.<ExplosiveEntity>of(ExplosiveEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<XuanYuanArrowArrowEntity>> XUAN_YUAN_ARROW_ARROW = register("xuan_yuan_arrow_arrow",
			EntityType.Builder.<XuanYuanArrowArrowEntity>of(XuanYuanArrowArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BaryonEntity>> BARYON = register("baryon",
			EntityType.Builder.<BaryonEntity>of(BaryonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<OnLaserEntity>> ON_LASER = register("on_laser",
			EntityType.Builder.<OnLaserEntity>of(OnLaserEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EngineeringAntimatterBombEntity>> ENGINEERING_ANTIMATTER_BOMB = register("engineering_antimatter_bomb",
			EntityType.Builder.<EngineeringAntimatterBombEntity>of(EngineeringAntimatterBombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		CrystalTurtleEntity.init(event);
		BaryonEntity.init(event);
		EngineeringAntimatterBombEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CRYSTAL_TURTLE.get(), CrystalTurtleEntity.createAttributes().build());
		event.put(BARYON.get(), BaryonEntity.createAttributes().build());
		event.put(ENGINEERING_ANTIMATTER_BOMB.get(), EngineeringAntimatterBombEntity.createAttributes().build());
	}
}
