package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SakuraPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xx = 0;
		double zz = 0;
		double rang = 0;
		ItemStack items = ItemStack.EMPTY;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 2000);
		rang = 32;
		for (int index0 = 0; index0 < 100; index0++) {
			xx = x + Mth.nextInt(RandomSource.create(), (int) (0 - rang), (int) rang);
			zz = z + Mth.nextInt(RandomSource.create(), (int) (0 - rang), (int) rang);
			SakuraTreeProcedure.execute(world, xx, y, zz);
		}
		OneiricconceptMod.queueServerWork(40, () -> {
			ItemTpProcedure.execute(world, x, y, z, entity, 64);
		});
	}
}