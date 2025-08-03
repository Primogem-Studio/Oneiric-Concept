package net.mcreator.oneiricconcept.procedures;

import net.minecraft.client.gui.screens.Screen;

public class AsdaProcedure {
	public static String execute() {
		if (Screen.hasControlDown()) {
			return "\u00A7b\u63D0\u9192\u60A8\uFF1A \u00A74\u5168\u7A81\u7A81\u4E86" + "\n" + "\u6CE8\uFF1A\u5728\u6C99\u6F20\u4F7F\u7528\u53EF\u80FD\u60CA\u6270\u6CD5\u8001\u53EC\u5524\u6C99\u66B4\u5229\u5203\u56E2\u5EFA\u4F60\u7684CPU";
		}
		return "\u00A7b\u63D0\u9192\u60A8\uFF1A\u6309\u4F4FCtrl\u67E5\u770B\u8BE6\u60C5";
	}
}