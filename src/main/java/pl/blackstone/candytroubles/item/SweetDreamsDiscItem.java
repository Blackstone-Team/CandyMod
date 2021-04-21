
package pl.blackstone.candytroubles.item;

import pl.blackstone.candytroubles.itemgroup.CandyTroublesItemGroup;
import pl.blackstone.candytroubles.CandytroublesModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

@CandytroublesModElements.ModElement.Tag
public class SweetDreamsDiscItem extends CandytroublesModElements.ModElement {
	@ObjectHolder("candytroubles:sweet_dreams_disc")
	public static final Item block = null;
	public SweetDreamsDiscItem(CandytroublesModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, CandytroublesModElements.sounds.get(new ResourceLocation("candytroubles:candydimension")),
					new Item.Properties().group(CandyTroublesItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("sweet_dreams_disc");
		}
	}
}
