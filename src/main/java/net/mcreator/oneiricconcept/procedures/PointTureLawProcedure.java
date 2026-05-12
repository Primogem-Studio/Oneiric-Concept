package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.ClipContext;

public class PointTureLawProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || !(entity instanceof Player player)) 
            return;

        // ===== 核心修改：获取玩家指向的实体 =====
        Entity targetEntity = getTargetedEntity(player, 5.0); // 5.0为射线检测距离（格）
        // =====================================
        
        if (targetEntity != null) {
            // 调用重载方法，传入指向的实体作为第二个参数
            PointTureLawProcedure.execute(world, targetEntity, entity);
        }
    }

    // 重载方法：处理实际逻辑（您原有的业务代码应放在此处）
    public static void execute(LevelAccessor world, Entity targetEntity, Entity sourceEntity) {
        // 此处添加您的核心逻辑（例如对目标实体造成伤害）
        targetEntity.hurt(sourceEntity.damageSources().generic(), 1.0F);
    }

    // ===== 关键工具方法：获取玩家视线指向的实体 =====
    private static Entity getTargetedEntity(Player player, double maxDistance) {
        Vec3 eyePos = player.getEyePosition();          // 射线起点（眼睛位置）
        Vec3 lookDir = player.getLookAngle();           // 视角方向向量
        Vec3 traceEnd = eyePos.add(lookDir.scale(maxDistance)); // 射线终点
        
        // 执行射线检测
        HitResult hitResult = player.level().clip(new ClipContext(
            eyePos,
            traceEnd,
            ClipContext.Block.COLLIDER,
            ClipContext.Fluid.NONE,
            player
        ));
        
        // 检查是否命中实体且非玩家自身
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            Entity hitEntity = ((EntityHitResult) hitResult).getEntity();
            if (hitEntity != player) return hitEntity;
        }
        return null; // 未命中有效实体
    }
}