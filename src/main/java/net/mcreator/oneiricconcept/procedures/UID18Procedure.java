package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Calendar;
import java.util.Arrays;

@EventBusSubscriber
public class UID18Procedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(double x, double y, double z, Entity entity) {
		execute(null, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String UUIDstr = "";
		String UID151617 = "";
		double checkk = 0;
		double modx = 0;
		double mody = 0;
		double modz = 0;
		double UID1567 = 0;
		double checktest = 0;
		if ((entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).UID).isEmpty()) {
			List<Integer> weighting = Arrays.asList(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			for (int index0 = 0; index0 < 8; index0++) {
				UID151617 = UID151617 + "" + "0123456789abcdef".indexOf(((entity.getStringUUID()).substring((int) index0, (int) (index0 + 1))), 0);
			}
			modx = Math.abs(x) % 99;
			mody = Math.abs(y) % 99;
			modz = Math.abs(z) % 99;
			UID1567 = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(UID151617) % 999;
			UUIDstr = (((modx < 10 ? "0" : "") + "" + Math.round(Math.floor(modx))) + "" + ((mody < 10 ? "0" : "") + "" + Math.round(Math.floor(mody))) + ((modz < 10 ? "0" : "") + "" + Math.round(Math.floor(modz)))) + ""
					+ new java.text.SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ((UID1567 < 100 ? "0" : "") + "" + Math.round(Math.floor(UID1567)));
			for (int index1 = 0; index1 < 17; index1++) {
				checktest = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((UUIDstr.substring((int) index1)).substring(0, 1)) * weighting.get((int) index1);
				OneiricconceptMod.LOGGER.debug(((UUIDstr.substring((int) index1)).substring(0, 1) + "--->" + checktest));
				checkk = checkk + checktest;
			}
			{
				OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.UID = UUIDstr + "\u00A7e" + "10X98765432".substring((int) (checkk % 11), (int) (checkk % 11 + 1));
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
