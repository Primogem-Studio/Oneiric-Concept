package net.mcreator.oneiricconcept.procedures;

import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.mcreator.ceshi.procedures.EventitemmssxrProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class EventPGCProcedure {
    public static void execute() {
        init();
    }

    public static void init() {
        //注册事件，包含效果，ID至少2000+
        Event_item_sxRProcedure.registerEvent(2000, (world, entity) -> {
            // 附属模组自定义事件逻辑
            if (entity instanceof Player player) {
                player.displayClientMessage(Component.literal("附属模组事件触发！"), false);
                // 添加附属模组特有的逻辑
                return true;
            }
            return false;
        });
        //示例
//        Event_item_sxRProcedure.registerEvent(2001, (world, entity) -> {return false;});
//        Event_item_sxRProcedure.registerEvent(2002, (world, entity) -> {return false;});


        // 注册事件组 包含 事件 ID至少1000+
        EventGroupProcedure.registerGroup(1000, (entity, world) -> {
            // 这里可以使用原石的事件+自己的事件
            return EventGroupProcedure.zu(entity, 1, 12, 1000, "§a附属模组事件");
        });
        //示例
//        EventGroupProcedure.registerGroup(1001, (entity, world) -> {return EventGroupProcedure.zu(entity, 999, 4, 0, "§a附属模组事件");});
//        EventGroupProcedure.registerGroup(1001, (entity, world) -> {return EventGroupProcedure.zu(entity, 5, 12, 0, "§a附属模组事件");});

        // 注册事件描述
        EventitemmssxrProcedure.registerDescription(2000, () -> "§e附属模组特殊事件\n§b提供独特奖励");
        //示例
//        EventitemmssxrProcedure.registerDescription(2000, () -> "§e附属模组特殊事件\n§b提供独特奖励");
//        EventitemmssxrProcedure.registerDescription(2000, () -> "§e附属模组特殊事件\n§b提供独特奖励");
    }
}