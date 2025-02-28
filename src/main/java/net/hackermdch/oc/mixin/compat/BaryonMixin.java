package net.hackermdch.oc.mixin.compat;

import net.hackermdch.oc.SpecialArrow;
import net.mcreator.oneiricconcept.entity.BaryonEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BaryonEntity.class)
public abstract class BaryonMixin extends Mob {
    protected BaryonMixin(EntityType<? extends Mob> type, Level level) {
        super(type, level);
    }

    @Redirect(method = "performRangedAttack", at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/entity/projectile/Arrow;"))
    private Arrow createArrow(Level level, LivingEntity source, ItemStack stack, ItemStack weapon) {
        return new SpecialArrow(level, source, stack, weapon);
    }
}
