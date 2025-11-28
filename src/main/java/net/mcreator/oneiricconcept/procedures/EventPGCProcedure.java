package net.mcreator.oneiricconcept.procedures;

import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.mcreator.ceshi.procedures.EventitemmssxrProcedure;
import net.minecraft.network.chat.Component;

public class EventPGCProcedure {
    public static void execute() {
        //事件
        Event_item_sxRProcedure.registerEvent(2000, (world, entity) -> {FallingMeatsetProcedure.execute(world, false);return true;});
        Event_item_sxRProcedure.registerEvent(2001, (world, entity) -> {FallingMeatsetProcedure.execute(world, true);return true;});
        Event_item_sxRProcedure.registerEvent(2002, (world, entity) -> {OccurrencesTheMarshmallowProcedure.execute(world,entity,1);return true;});
        Event_item_sxRProcedure.registerEvent(2003, (world, entity) -> {OccurrencesTheMarshmallowProcedure.execute(world,entity,2);return true;});
        //事件组
        EventGroupProcedure.registerGroup(1000, (entity, world) -> {return EventGroupProcedure.zu(entity, 2000, 2001, 7, "§e我不吃牛肉...吗？");});
        EventGroupProcedure.registerGroup(1001, (entity, world) -> {return EventGroupProcedure.zu(entity, 2002, 2003, 0, "§c飞向高天");});
        EventGroupProcedure.registerGroup(1002, (entity, world) -> {return EventGroupProcedure.zu(entity, 7, 13, 0, "§a奖励");});
        EventGroupProcedure.registerGroup(1003, (entity, world) -> {return EventGroupProcedure.zu(entity, 8, 14, 0, "§a奖励");});
        //事件描述
        EventitemmssxrProcedure.registerDescription(2000, () -> "§d梦华构想§e模组的肉馅§c将不再掉落");
        EventitemmssxrProcedure.registerDescription(2001, () -> "§d梦华构想§e模组的肉馅§a将继续掉落");
        EventitemmssxrProcedure.registerDescription(2002, () -> Component.translatable("translation.oneiricconcept.marshmallow").getString());
        EventitemmssxrProcedure.registerDescription(2003, () -> Component.translatable("translation.oneiricconcept.marshmallow2").getString());
    }
}
