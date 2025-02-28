package net.hackermdch.oc.mixin.compat;

import net.hacker.genshincraft.element.Element;
import net.hacker.genshincraft.element.ElementDamageSource;
import net.mcreator.oneiricconcept.procedures.ElementDamageProcedure;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ElementDamageProcedure.class)
public class ElementDamageMixin {
    /**
     * @author hackermdch
     * @reason overwrite
     */
    @Overwrite
    public static DamageSource execute(DamageSource damagesource, boolean apply, boolean cooldown, boolean critical, boolean knockback, double element, double quantity) {
        var q = Math.clamp((float) quantity, 0, 3);
        return new ElementDamageSource(damagesource, Element.fromType((int) element, q, Element.getDelta(q))).setApply(apply).setCritical(critical).setCooldown(cooldown).setKnockback(knockback);
    }
}
