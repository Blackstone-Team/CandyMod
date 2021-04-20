
package pl.blackstone.candytroubles.itemgroup;

import pl.blackstone.candytroubles.item.CandyItem;
import pl.blackstone.candytroubles.CandytroublesModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@CandytroublesModElements.ModElement.Tag
public class CandyTroublesItemGroup extends CandytroublesModElements.ModElement {
	public CandyTroublesItemGroup(CandytroublesModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcandy_troubles") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CandyItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
