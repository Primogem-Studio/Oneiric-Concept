package net.mcreator.oneiricconcept.procedures;

import net.minecraft.client.gui.screens.Screen;

public class HsctrlProcedure {
	public static String execute(String ctrl, String ctrl0) {
		if (ctrl == null || ctrl0 == null)
			return "";
		if (Screen.hasControlDown()) {
			return ctrl + "\n";
		}
		return "\u00A77\u6309\u4F4F\u00A7bCtrl\u00A77\u67E5\u770B" + ctrl0 + "\n";
	}
}
