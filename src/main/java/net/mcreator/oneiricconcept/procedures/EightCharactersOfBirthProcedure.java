package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.mm;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EightCharactersOfBirthProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		boolean isLeapYear = false;
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
	}
}
