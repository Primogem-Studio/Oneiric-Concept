package net.mcreator.oneiricconcept;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.per.primogemcraft.system.weapon.WeaponEnhancement;
import net.per.primogemcraft.system.weapon.WeaponState;

/** PrimogemCraftNeo APIs used by the generated procedures. */
public final class PGCApi {
    private PGCApi() {}

    public static double refinementBonus(Entity entity, ItemStack stack) {
        // OC uses zero-based refinements; Neo stores the first tier as 1.
        return Math.max(0, WeaponEnhancement.refinementOf(entity instanceof Player player ? player : null, stack) - 1);
    }

    public static String weaponDescription(Entity entity, ItemStack stack, String description) {
        return "§eLv." + WeaponState.of(stack).level() + " §6精炼 "
                + (int) (refinementBonus(entity, stack) + 1) + "\n" + description;
    }
}
