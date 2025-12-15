package net.mcreator.oneiricconcept;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

// 注册为MOD事件总线的订阅者
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ApothicIntegration {

    // 通用初始化事件
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // 此处可添加需要在通用初始化阶段执行的逻辑
        // 例如注册监听器或检查模组兼容性
    }

    // 数据生成事件（如果需要动态生成数据）
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        // 仅在数据生成阶段且神化附魔模组存在时执行
        if (event.includeServer() && event.getModContainer().getModInfo().getModId().equals("oneiricconcept")) {
            // 这里可以添加动态生成数据的逻辑（如果需要）
            // 例如通过代码生成上述JSON配置
        }
    }
}