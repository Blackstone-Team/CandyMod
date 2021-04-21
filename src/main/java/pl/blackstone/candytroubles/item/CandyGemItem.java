
package pl.blackstone.candytroubles.item;

import pl.blackstone.candytroubles.itemgroup.CandyTroublesItemGroup;
import pl.blackstone.candytroubles.CandytroublesModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@CandytroublesModElements.ModElement.Tag
public class CandyGemItem extends CandytroublesModElements.ModElement {
	@ObjectHolder("candytroubles:candy_gem")
	public static final Item block = null;
	public CandyGemItem(CandytroublesModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CandyTroublesItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("candy_gem");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
