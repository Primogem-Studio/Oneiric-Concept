package net.hackermdch.oc.mixin.compat;

import net.hacker.genshincraft.misc.TypeDamageSource;
import net.mcreator.oneiricconcept.entity.OnLaserEntity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

import static net.hacker.genshincraft.misc.TypeDamageSource.Type.QUANTUM;

@Mixin(OnLaserEntity.class)
public abstract class OnLaserEntityMixin extends AbstractArrow {
    protected OnLaserEntityMixin(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    @Override
    public DamageSources damageSources() {
        return new DamageSources(level().registryAccess()) {
            @Override
            public DamageSource source(ResourceKey<DamageType> key) {
                return new TypeDamageSource(damageTypes.getHolderOrThrow(key), null, null, QUANTUM);
            }

            @Override
            public DamageSource source(ResourceKey<DamageType> key, Entity source) {
                return new TypeDamageSource(damageTypes.getHolderOrThrow(key), source, source, QUANTUM);
            }

            @Override
            public DamageSource source(ResourceKey<DamageType> key, Entity directSource, Entity source) {
                return new TypeDamageSource(damageTypes.getHolderOrThrow(key), directSource, source, QUANTUM);
            }
        };
    }
}
