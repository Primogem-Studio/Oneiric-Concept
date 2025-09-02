package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

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
		String testext = "";
		Refinement = WuqijinglianupProcedure.execute(entity, itemstack);
		LastTime = GetDoubleNBTTagProcedure.execute(itemstack, IsLeft ? "time_L" : "time_R");
		DBtagname = IsLeft ? "Charged_L" : "Charged_R";
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			testext = ("\u83B7\u53D6\u5230\u7CBE\u70BC\u7B49\u7EA7\uFF1A\u00A79" + Refinement + "\n") + "" + ("\u00A7r\u83B7\u53D6\u5230\u6280\u80FD\u6A21\u5F0FL\uFF1A\u00A79" + IsLeft + "\n")
					+ ("\u00A7r\u83B7\u53D6\u5230\u4E0A\u6B21\u4F7F\u7528\u65F6\u95F4\uFF1A\u00A79" + LastTime + "\n") + ("\u00A7r\u83B7\u53D6\u5230\u5F53\u524D\u4E16\u754C\u65F6\u95F4\uFF1A\u00A79" + world.dayTime() + "\n")
					+ ("\u00A7r\u83B7\u53D6\u5230\u81EA\u4E0A\u6B21\u4F7F\u7528\uFF1A\u00A79" + (world.dayTime() - LastTime) + "\n") + ("\u00A7r\u83B7\u53D6\u5230\u4F20\u5165\u7684\u51B7\u5374\u65F6\u95F4\uFF1A\u00A79" + cooling + "\n")
					+ ("\u00A7r\u83B7\u53D6\u5230\u57FA\u4E8E\u7CBE\u70BC\u7B49\u7EA7\u7684\u51B7\u5374\u65F6\u95F4\uFF1A\u00A79" + cooling * (1 - 0.1 * Refinement) + "\u00A7r");
		}
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean(DBtagname) && cooling * (1 - 0.1 * Refinement) < world.dayTime() - LastTime) {
			{
				final String _tagName = DBtagname;
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			DBtagnu = IsLeft ? 0 : 1;
			DBtagname = "textures";
			for (int index0 = 0; index0 < 2; index0++) {
				testext = "\n" + testext + "\u5C06\u7269\u54C1\u6807\u7B7E\u00A7e" + DBtagname + "\u00A7r\u8BBE\u7F6E\u4E3A\u00A79" + DBtagnu + "\u00A7r";
				{
					final String _tagName = DBtagname;
					final double _tagValue = DBtagnu;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				DBtagnu = world.dayTime();
				DBtagname = IsLeft ? "time_L" : "time_R";
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
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(testext), false);
		}
	}
}