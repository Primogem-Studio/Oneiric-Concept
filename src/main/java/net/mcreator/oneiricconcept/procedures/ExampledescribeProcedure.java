package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class ExampledescribeProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		return PgcwuqiProcedure.execute(itemstack,
				"\u00A76\u00A7l\u00A7n\u540D\u79F0a" + "\n" + "\u00A7e\u6807\u51C6\u63CF\u8FF0\u5185\u5BB9\uFF0C\u63CF\u8FF0\u503C\uFF1A\u00A7b" + new java.text.DecimalFormat("##.##").format(a)
						+ "\u00A7e\uFF0C\u53D7\u7CBE\u70BC\u7B49\u7EA7\u5F71\u54CD\u7684\u6570\u503C\u5E94\u5F53\u6DE1\u84DD\u8272\u9AD8\u4EAE\uFF0C\u56FA\u5B9A\u503C\u5219\u4E3A\u00A7e(\u9EC4\u8272)" + "\n" + "\u00A76\u00A7l\u00A7n\u540D\u79F0b"
						+ "\n" + "\u00A7e\u4EE5\u6B64\u7C7B\u63A8" + "\n" + "\u00A7c\u00A7l\u7CBE\u70BC\u6B66\u5668\u5E94\u5F53\u88AB\u6807\u8BB0\u5728<pgc:wuqi>\u7684\u7269\u54C1TAG\u4E2D" + "\n"
						+ "\u00A7c<pgc:wuqi/5>\u4EE3\u8868\u4E94\u661F\u7EA7\u6B66\u5668\uFF0C\u53EF\u4EE5\u62C6\u6210\u81EA\u9009\u788E\u7247\uFF0C\u614E\u7528");
	}
}
