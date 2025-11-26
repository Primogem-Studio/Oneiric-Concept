package net.mcreator.oneiricconcept.procedures;

import net.mcreator.ceshi.procedures.EventGroupProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ExamplexsProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        boolean o = false;
        Entity e = null;
        o = world.getLevelData().isRaining();
        e = entity;
        EventGroupProcedure.execute(world, entity, 1000);//为实体打开20号事件组
        java.util.List<Integer> g = net.mcreator.ceshi.procedures.EventGroupProcedure.getRegisteredGroupIds();
        System.out.println(g);//这两行不管！！
    }
}