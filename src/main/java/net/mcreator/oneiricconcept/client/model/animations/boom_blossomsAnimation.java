package net.mcreator.oneiricconcept.client.model.animations;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

// Save this class in your mod and generate all required imports
/**
 * Made with Blockbench 5.0.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class boom_blossomsAnimation {
	public static final AnimationDefinition bomb = AnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("melon",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("melon",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 33.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5417F, KeyframeAnimations.posVec(1.0F, 33.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5833F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6667F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.9167F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.0833F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.1667F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.3333F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.4167F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5833F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.6667F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.8333F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.9167F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0833F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.1667F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.3333F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.4167F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5833F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.6667F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75F, KeyframeAnimations.posVec(-1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.8333F, KeyframeAnimations.posVec(1.0F, 33.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.9167F, KeyframeAnimations.posVec(1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.0F, KeyframeAnimations.posVec(-1.0F, 33.0F, -1.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("melon", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.0F, KeyframeAnimations.scaleVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.LINEAR)))
			.build();
}