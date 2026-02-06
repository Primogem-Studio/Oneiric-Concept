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
public class xiao_lanternAnimation {
	public static final AnimationDefinition load = AnimationDefinition.Builder.withLength(16.0F).looping().addAnimation("floot", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.4976F, 0.109F, -2.4976F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4.0F, KeyframeAnimations.degreeVec(2.4976F, 0.109F, 0.0024F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(6.0F, KeyframeAnimations.degreeVec(2.4976F, 0.109F, 2.5024F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, 0.218F, 2.4952F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(10.0F, KeyframeAnimations.degreeVec(-2.5F, 0.2176F, -0.0143F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(12.0F, KeyframeAnimations.degreeVec(-2.5F, 0.2176F, -2.5143F), AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(14.0F, KeyframeAnimations.degreeVec(-0.0024F, 0.327F, -2.5024F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(16.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("all",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(12.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(16.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition size = AnimationDefinition.Builder.withLength(0.0F)
			.addAnimation("all", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("all", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.3F, 0.3F, 0.3F), AnimationChannel.Interpolations.LINEAR))).build();
}