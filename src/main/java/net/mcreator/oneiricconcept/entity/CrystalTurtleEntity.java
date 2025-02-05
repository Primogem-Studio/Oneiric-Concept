
package net.mcreator.oneiricconcept.entity;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.procedures.UnShrinkingShellProcedure;
import net.mcreator.oneiricconcept.procedures.TurtleDamageProcedure;
import net.mcreator.oneiricconcept.procedures.ShrinkingShellSuoKeProcedure;
import net.mcreator.oneiricconcept.procedures.CrystalTurtleTickProcedure;
import net.mcreator.oneiricconcept.procedures.CrystalHeadProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class CrystalTurtleEntity extends Animal {
	public static final EntityDataAccessor<Integer> DATA_ShrinkingShellTime = SynchedEntityData.defineId(CrystalTurtleEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_crystal = SynchedEntityData.defineId(CrystalTurtleEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_IsShrinking = SynchedEntityData.defineId(CrystalTurtleEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_IsCrystallized = SynchedEntityData.defineId(CrystalTurtleEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_IsUnShrinking = SynchedEntityData.defineId(CrystalTurtleEntity.class, EntityDataSerializers.BOOLEAN);
	public final AnimationState animationState2 = new AnimationState();
	public final AnimationState animationState3 = new AnimationState();
	public final AnimationState animationState4 = new AnimationState();

	public CrystalTurtleEntity(EntityType<CrystalTurtleEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (CrystalTurtleEntity.this.isInWater())
					CrystalTurtleEntity.this.setDeltaMovement(CrystalTurtleEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !CrystalTurtleEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - CrystalTurtleEntity.this.getX();
					double dy = this.wantedY - CrystalTurtleEntity.this.getY();
					double dz = this.wantedZ - CrystalTurtleEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * CrystalTurtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					CrystalTurtleEntity.this.setYRot(this.rotlerp(CrystalTurtleEntity.this.getYRot(), f, 10));
					CrystalTurtleEntity.this.yBodyRot = CrystalTurtleEntity.this.getYRot();
					CrystalTurtleEntity.this.yHeadRot = CrystalTurtleEntity.this.getYRot();
					if (CrystalTurtleEntity.this.isInWater()) {
						CrystalTurtleEntity.this.setSpeed((float) CrystalTurtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						CrystalTurtleEntity.this.setXRot(this.rotlerp(CrystalTurtleEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(CrystalTurtleEntity.this.getXRot() * (float) (Math.PI / 180.0));
						CrystalTurtleEntity.this.setZza(f3 * f1);
						CrystalTurtleEntity.this.setYya((float) (f1 * dy));
					} else {
						CrystalTurtleEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					CrystalTurtleEntity.this.setSpeed(0);
					CrystalTurtleEntity.this.setYya(0);
					CrystalTurtleEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_ShrinkingShellTime, 0);
		builder.define(DATA_crystal, 0);
		builder.define(DATA_IsShrinking, false);
		builder.define(DATA_IsCrystallized, false);
		builder.define(DATA_IsUnShrinking, false);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowParentGoal(this, 0.8) {
			@Override
			public boolean canUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canUse() && UnShrinkingShellProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canContinueToUse() && UnShrinkingShellProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canUse() && UnShrinkingShellProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canContinueToUse() && UnShrinkingShellProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canUse() && UnShrinkingShellProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canContinueToUse() && UnShrinkingShellProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new TryFindWaterGoal(this) {
			@Override
			public boolean canUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canUse() && UnShrinkingShellProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = CrystalTurtleEntity.this.getX();
				double y = CrystalTurtleEntity.this.getY();
				double z = CrystalTurtleEntity.this.getZ();
				Entity entity = CrystalTurtleEntity.this;
				Level world = CrystalTurtleEntity.this.level();
				return super.canContinueToUse() && UnShrinkingShellProcedure.execute(entity);
			}
		});
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();
		if (!TurtleDamageProcedure.execute(world, x, y, z, entity))
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		TurtleDamageProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataShrinkingShellTime", this.entityData.get(DATA_ShrinkingShellTime));
		compound.putInt("Datacrystal", this.entityData.get(DATA_crystal));
		compound.putBoolean("DataIsShrinking", this.entityData.get(DATA_IsShrinking));
		compound.putBoolean("DataIsCrystallized", this.entityData.get(DATA_IsCrystallized));
		compound.putBoolean("DataIsUnShrinking", this.entityData.get(DATA_IsUnShrinking));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataShrinkingShellTime"))
			this.entityData.set(DATA_ShrinkingShellTime, compound.getInt("DataShrinkingShellTime"));
		if (compound.contains("Datacrystal"))
			this.entityData.set(DATA_crystal, compound.getInt("Datacrystal"));
		if (compound.contains("DataIsShrinking"))
			this.entityData.set(DATA_IsShrinking, compound.getBoolean("DataIsShrinking"));
		if (compound.contains("DataIsCrystallized"))
			this.entityData.set(DATA_IsCrystallized, compound.getBoolean("DataIsCrystallized"));
		if (compound.contains("DataIsUnShrinking"))
			this.entityData.set(DATA_IsUnShrinking, compound.getBoolean("DataIsUnShrinking"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState2.animateWhen(ShrinkingShellSuoKeProcedure.execute(this), this.tickCount);
			this.animationState3.animateWhen(UnShrinkingShellProcedure.execute(this), this.tickCount);
			this.animationState4.animateWhen(CrystalHeadProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CrystalTurtleTickProcedure.execute(this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		CrystalTurtleEntity retval = OneiricconceptModEntities.CRYSTAL_TURTLE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(OneiricconceptModBlocks.PGC_PG1.get())).test(stack);
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.9);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 3);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.2);
		return builder;
	}
}
