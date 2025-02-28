package net.hackermdch.oc;

import net.hacker.genshincraft.misc.TypeDamageSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static net.hacker.genshincraft.misc.TypeDamageSource.Type.QUANTUM;

public class SpecialArrow extends Arrow {
    public SpecialArrow(Level level, LivingEntity owner, ItemStack stack, @Nullable ItemStack weapon) {
        super(level, owner, stack, weapon);
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
