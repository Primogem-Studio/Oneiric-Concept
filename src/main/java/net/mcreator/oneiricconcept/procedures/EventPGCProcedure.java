package net.mcreator.oneiricconcept.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.per.primogemcraft.enchantment.EnchantGrade;
import net.per.primogemcraft.registry.PGCItems;
import net.per.primogemcraft.system.event.*;

import java.util.HashMap;
import java.util.Map;

import static net.mcreator.oneiricconcept.init.OneiricconceptModEntities.BARYON;

public class EventPGCProcedure {
    private static final Map<Integer, EventGroup> GROUPS = new HashMap<>();

    public static void execute() {
        if (!GROUPS.isEmpty()) return;
        var stopMeat = event("§e不再掉落肉馅", ctx -> { FallingMeatsetProcedure.execute(ctx.level(), false); return true; });
        var startMeat = event("§e继续掉落肉馅", ctx -> { FallingMeatsetProcedure.execute(ctx.level(), true); return true; });
        var marshmallow = EventRegistry.register(Component.translatable("translation.oneiricconcept.marshmallow"), Component.empty(),
                ctx -> { OccurrencesTheMarshmallowProcedure.execute(ctx.level(), ctx.player(), 1); return true; });
        var marshmallow2 = EventRegistry.register(Component.translatable("translation.oneiricconcept.marshmallow2"), Component.empty(),
                ctx -> { OccurrencesTheMarshmallowProcedure.execute(ctx.level(), ctx.player(), 2); return true; });
        var reward = event("§a奖励：附魔", ctx -> ctx.enchant(EnchantGrade.LOW));
        var reward2 = event("§a奖励：附魔", ctx -> ctx.enchant(EnchantGrade.MEDIUM));
        var baryons = event("§d与3个重子战斗，击杀两只即可获得奖励", ctx ->
                EventCombat.challenge(ctx, BARYON.get(), 3, 2, null, completion -> completion.enchant(EnchantGrade.MEDIUM)));
        var diamond = event("§6获得非洲之心", ctx -> {
            var player = ctx.player();
            WhiteDiamondFakeProcedure.execute(ctx.level(), player.getX(), player.getY(), player.getZ(), player);
            return ctx.give(new ItemStack(PGCItems.FOOLS_MASK.get()));
        });
        var audience = event("§6为火花花的直播间刷人气", ctx -> { PropagandaArmyOrderProcedure.execute(ctx.level(), ctx.player(), true, 100, -1, 60); return true; });
        var moreAudience = event("§6为火花花的直播间刷很多人气", ctx -> { PropagandaArmyOrderProcedure.execute(ctx.level(), ctx.player(), true, 200, -1, 90); return true; });
        var leave = RandomEvents.leaveEvent();
        group(1000, "§e我不吃牛肉...吗？", stopMeat, startMeat, reward);
        group(1001, "§c棉花糖号", marshmallow, marshmallow2, leave);
        group(1002, "§a奖励", reward, reward2, leave);
        group(1003, "§a奖励", reward2, reward, leave);
        group(1004, "§d与重子搏斗！！！", baryons, baryons, baryons);
        group(1005, "§c至高奖励！", diamond, reward, reward2);
        group(1006, "§c超级直播矩阵", audience, moreAudience, leave);
    }

    private static RandomEvent event(String title, EventAction action) {
        return EventRegistry.register(Component.literal(title), Component.empty(), action);
    }

    private static void group(int legacyNumber, String title, RandomEvent... events) {
        GROUPS.put(legacyNumber, EventRegistry.registerGroup(EventGroup.of(Component.literal(title), events)));
    }

    public static void trigger(Entity entity, int number) {
        if (entity instanceof ServerPlayer player) {
            execute();
            EventRegistry.trigger(player, GROUPS.getOrDefault(number, EventRegistry.group(number)));
        }
    }
}
