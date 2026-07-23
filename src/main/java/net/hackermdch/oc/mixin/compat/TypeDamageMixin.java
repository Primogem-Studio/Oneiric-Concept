package net.hackermdch.oc.mixin.compat;

import net.hackermdch.genshincraft.misc.TypeDamageSource;
import net.mcreator.oneiricconcept.procedures.TypeDamageProcedure;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.hackermdch.genshincraft.misc.TypeDamageSource.Type.*;

@Mixin(TypeDamageProcedure.class)
public class TypeDamageMixin {
    /**
     * @author hackermdch
     * @reason overwrite
     */
    @Overwrite
    public static DamageSource execute(DamageSource damagesource, boolean cooldown, boolean critical, boolean knockback, double type) {
        return switch ((int) type) {
            case 1 ->
                    new TypeDamageSource(damagesource, QUANTUM).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
            case 2 ->
                    new TypeDamageSource(damagesource, IMAGINARY).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
            case 3 ->
                    new TypeDamageSource(damagesource, LUNAR_CHARGED).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
            case 4 ->
                    new TypeDamageSource(damagesource, LUNAR_BLOOM).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
            case 5 ->
                    new TypeDamageSource(damagesource, LUNAR_CRYSTALLIZE).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
            default ->
                    new TypeDamageSource(damagesource, PHYSICAL).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
        };
    }
}
