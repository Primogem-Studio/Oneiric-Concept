package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.oneiricconcept.init.OneiricconceptModFluids;

public class MemoriaItem extends BucketItem {
	public MemoriaItem() {
		super(OneiricconceptModFluids.MEMORIA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}