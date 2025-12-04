package net.mcreator.oneiricconcept.procedures;

import net.mcreator.ceshi.api.EventRegistry;
import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.mcreator.ceshi.procedures.EventitemmssxrProcedure;
import net.minecraft.network.chat.Component;

import javax.naming.event.EventContext;

import static net.mcreator.oneiricconcept.init.OneiricconceptModEntities.BARYON;

public class EventPGCProcedure {
    public static void execute() {
        //事件
        EventRegistry.registerEvent(2000, ctx -> {FallingMeatsetProcedure.execute(ctx.getWorld(), false);return true;});
        EventRegistry.registerEvent(2001, ctx -> {FallingMeatsetProcedure.execute(ctx.getWorld(), true);return true;});
        EventRegistry.registerEvent(2002, ctx -> {OccurrencesTheMarshmallowProcedure.execute(ctx.getWorld(),ctx.getPlayer(),1);return true;});
        EventRegistry.registerEvent(2003, ctx -> { OccurrencesTheMarshmallowProcedure.execute(ctx.getWorld(),ctx.getPlayer(),2);return true;});
        EventRegistry.registerEvent(2004, ctx -> ctx.spawnEntitiesInRange(BARYON.get(), 3, 20, null, false, entity -> {
            ctx.applyEntityModifier(entity, livingEntity -> {ctx.invokeKillAll(livingEntity, 2, _true -> {ctx.createSimpleGroup(8, EventGroupProcedure.getRandomRegisteredEventId(ctx.getWorld()), 2000, "§a奖励");});});}));

        //事件组
        EventRegistry.registerGroup(1000, ctx -> ctx.zu(2000, 2001, 7, "§e我不吃牛肉...吗？"));
        EventRegistry.registerGroup(1001, ctx -> ctx.zu(2002, 2003, 0, "§c飞向高天"));
        EventRegistry.registerGroup(1002, ctx -> ctx.zu(7, 13, 0, "§a奖励"));
        EventRegistry.registerGroup(1003, ctx -> ctx.zu(8, 14, 0, "§a奖励"));
        EventRegistry.registerGroup(1004, ctx -> ctx.zu(2004, 2004, 2004, "§d与重子搏斗！！！"));
        //事件描述
        EventRegistry.registerDescription(2000, () -> "§d梦华构想§e模组的肉馅§c将不再掉落");
        EventRegistry.registerDescription(2001, () -> "§d梦华构想§e模组的肉馅§a将继续掉落");
        EventRegistry.registerDescription(2002, () -> Component.translatable("translation.oneiricconcept.marshmallow").getString());
        EventRegistry.registerDescription(2003, () -> Component.translatable("translation.oneiricconcept.marshmallow2").getString());
        EventRegistry.registerDescription(2004, () -> "§d与3个重子战斗，击杀两只即可获得奖励");
    }
}
