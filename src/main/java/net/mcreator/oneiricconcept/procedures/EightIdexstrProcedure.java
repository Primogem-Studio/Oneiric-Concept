package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.s;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class EightIdexstrProcedure {
	public static double execute(String column, String mapp, String stems) {
		if (column == null || mapp == null || stems == null)
			return 0;
		double indexx = 0;
		String strr = "";
		OneiricconceptMod.LOGGER.warn(("01:" + column));
		strr = column.substring(0, 1);
		OneiricconceptMod.LOGGER.warn(("2:" + strr));
		OneiricconceptMod.LOGGER.warn(("stems:" + stems));
		indexx = stems.indexOf(strr, 0);
		OneiricconceptMod.LOGGER.warn(("3:" + ("" + indexx)));
		strr = mapp.substring((int) indexx, (int) (indexx + 1));
		OneiricconceptMod.LOGGER.warn(("4:" + strr));
		indexx = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(strr);
		OneiricconceptMod.LOGGER.warn(("5:" + ("" + indexx)));
		return indexx;
	}
}
