package net.mcreator.oneiricconcept.procedures;

import net.hacker.genshincraft.advancement.CustomTriggers;
import net.mcreator.ceshi.api.EventRegistry;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.mcreator.ceshi.procedures.Event_item_sxRProcedure;
import net.mcreator.ceshi.procedures.EventitemmssxrProcedure;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

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
        EventRegistry.registerEvent(2005, ctx -> {
            ctx.getPlayer().getServer().getPlayerList().broadcastSystemMessage(Component.literal((ctx.getPlayer().getDisplayName().getString())+"完成了挑战§5[一颗永流传]"), false);
            ctx.setGuiItem(new ItemStack(PrimogemcraftModItems.QWYZZM.get()), 1,1,4);return true;});
        //事件组
        EventRegistry.registerGroup(1000, ctx -> ctx.zu(2000, 2001, 7, "§e我不吃牛肉...吗？"));
        EventRegistry.registerGroup(1001, ctx -> ctx.zu(2002, 2003, 0, "§c飞向高天"));
        EventRegistry.registerGroup(1002, ctx -> ctx.zu(7, 13, 0, "§a奖励"));
        EventRegistry.registerGroup(1003, ctx -> ctx.zu(8, 14, 0, "§a奖励"));
        EventRegistry.registerGroup(1004, ctx -> ctx.zu(2004, 2004, 2004, "§d与重子搏斗！！！"));
        EventRegistry.registerGroup(1005, ctx -> ctx.zu(2005, 7, 13, "§c至高奖励！"));
        //事件描述
        EventRegistry.registerDescription(2000, () -> "§d梦华构想§e模组的肉馅§c将不再掉落");
        EventRegistry.registerDescription(2001, () -> "§d梦华构想§e模组的肉馅§a将继续掉落");
        EventRegistry.registerDescription(2002, () -> Component.translatable("translation.oneiricconcept.marshmallow").getString());
        EventRegistry.registerDescription(2003, () -> Component.translatable("translation.oneiricconcept.marshmallow2").getString());
        EventRegistry.registerDescription(2004, () -> "§d与3个重子战斗，击杀两只即可获得奖励");
        EventRegistry.registerDescription(2005, () -> "§6你将获得非洲之心");
    }
}
