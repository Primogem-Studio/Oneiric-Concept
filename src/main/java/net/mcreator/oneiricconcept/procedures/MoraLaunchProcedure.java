package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MoraLaunchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack MainHand = ItemStack.EMPTY;
		ItemStack SecondaryHand = ItemStack.EMPTY;
		double nu = 0;
		SecondaryHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		if (SecondaryHand.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine1")))) {
			MoraDamageProcedure.execute(world, entity, 1, 5);
			nu = 20;
		} else if (SecondaryHand.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine2")))) {
			MoraDamageProcedure.execute(world, entity, 2, 5);
			nu = 20;
		} else if (SecondaryHand.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine3")))) {
			MoraDamageProcedure.execute(world, entity, 4, 16);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.trident.thunder")), SoundSource.PLAYERS, 2, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y + 2, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			nu = 0;
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 1.3), z, 10, 1.3, 1.3, 1.3, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, x, (y + 1.3), z, (int) nu, 0.1, 0.1, 0.1, 0.1);
	}
}
