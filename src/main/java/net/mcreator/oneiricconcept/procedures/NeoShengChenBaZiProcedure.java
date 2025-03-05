package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.mm;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

@EventBusSubscriber
public class NeoShengChenBaZiProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean isLeapYear = false;
		List<Object> indexHeavenlyStems = new ArrayList<>();
		List<Object> idnexEarthlyBranches = new ArrayList<>();
		String heavenlyStems = "";
		String earthlyBranches = "";
		String monthStemMapping = "";
		String hourStemMapping = "";
		String calculateYearColumn = "";
		String calculateMonthColumn = "";
		String calculateDayColumn = "";
		String calculateHourColumn = "";
		double year = 0;
		double offset = 0;
		double month = 0;
		double cc = 0;
		double yy = 0;
		double dd = 0;
		double mm = 0;
		double ww = 0;
		double hourBranchIndex = 0;
		if ((entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).EightCharactersofBirth).isEmpty()) {
			heavenlyStems = "\u7532\u4E59\u4E19\u4E01\u620A\u5DF1\u5E9A\u8F9B\u58EC\u7678";
			earthlyBranches = "\u5B50\u4E11\u5BC5\u536F\u8FB0\u5DF3\u5348\u672A\u7533\u9149\u620C\u4EA5";
			monthStemMapping = "2468024680";
			hourStemMapping = "0246802468";
			year = Calendar.getInstance().get(Calendar.YEAR);
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
			offset = year - 1900;
			calculateYearColumn = EightCharactersIndexProcedure.execute((0 + offset) % 12, (6 + offset) % 10);
			calculateMonthColumn = EightCharactersIndexProcedure.execute((month - 1) / 12, (EightIdexstrProcedure.execute(calculateYearColumn, monthStemMapping, heavenlyStems) + month - 1) % 10);
			if (month < 3) {
				mm = month + 12;
				yy = year - 1;
			}
			cc = yy / 100;
			yy = yy % 100;
			dd = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			ww = (cc / 4 - 2 * cc + yy + yy / 4 + (13 * (mm + 1)) / 5 + dd - 1) % 60;
			calculateDayColumn = EightCharactersIndexProcedure.execute(ww % 12, ww % 10);
			hourBranchIndex = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) / 2) % 12;
			calculateHourColumn = EightCharactersIndexProcedure.execute(hourBranchIndex, (EightIdexstrProcedure.execute(calculateDayColumn, hourStemMapping, heavenlyStems) + hourBranchIndex) % 10);
			{
				OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.EightCharactersofBirth = calculateYearColumn + "" + calculateMonthColumn + calculateDayColumn + calculateHourColumn;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
