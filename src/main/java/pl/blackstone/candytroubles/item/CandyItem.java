
package pl.blackstone.candytroubles.item;

import pl.blackstone.candytroubles.procedures.CandyFoodEatenProcedure;
import pl.blackstone.candytroubles.itemgroup.CandyTroublesItemGroup;
import pl.blackstone.candytroubles.CandytroublesModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

@CandytroublesModElements.ModElement.Tag
public class CandyItem extends CandytroublesModElements.ModElement {
	@ObjectHolder("candytroubles:candy")
	public static final Item block = null;
	public CandyItem(CandytroublesModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(CandyTroublesItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.3f).build()));
			setRegistryName("candy");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CandyFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
