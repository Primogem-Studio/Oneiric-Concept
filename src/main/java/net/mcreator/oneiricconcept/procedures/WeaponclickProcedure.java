package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class WeaponclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, boolean IsLeft, double cooling) {
		if (entity == null)
			return;
		double angle = 0;
		double num = 0;
		double speed = 0;
		double DBtagnu = 0;
		double Refinement = 0;
		double LastTime = 0;
		String DBtagname = "";
		String valueTagName = "";
		Refinement = GetDoubleNBTTagProcedure.execute(itemstack, "jing_lian");
		LastTime = GetDoubleNBTTagProcedure.execute(itemstack, "time");
		DBtagname = IsLeft ? "Charged_L" : "Charged_R";
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(DBtagname) || cooling * (1 - 0.1 * Refinement) < LastTime - world.dayTime()) {
			{
				final String _tagName = DBtagname;
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			DBtagnu = 1;
			DBtagname = "textures";
			for (int index0 = 0; index0 < 2; index0++) {
				{
					final String _tagName = DBtagname;
					final double _tagValue = DBtagnu;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				DBtagnu = world.dayTime();
				DBtagname = "time";
			}
			for (int index1 = 0; index1 < (int) (2 + Refinement); index1++) {
				num = 160 + 20 * index1;
				speed = 3 * index1;
				for (int index2 = 0; index2 < (int) num; index2++) {
					angle = (2 * Math.PI * index2) / num;
					world.addParticle(ParticleTypes.ENCHANT, x, (y + entity.getBbHeight() * 0.5), z, (speed * Math.cos(angle)), 0, (speed * Math.sin(angle)));
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.NEUTRAL, 1, 20);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.NEUTRAL, 1, 20, false);
				}
			}
		}
	}
}
