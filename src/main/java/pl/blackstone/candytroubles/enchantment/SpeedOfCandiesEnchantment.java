
package pl.blackstone.candytroubles.enchantment;

import pl.blackstone.candytroubles.CandytroublesModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

@CandytroublesModElements.ModElement.Tag
public class SpeedOfCandiesEnchantment extends CandytroublesModElements.ModElement {
	@ObjectHolder("candytroubles:speed_of_candies")
	public static final Enchantment enchantment = null;
	public SpeedOfCandiesEnchantment(CandytroublesModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("speed_of_candies"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.ARMOR_FEET, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 6;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 2;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(Items.LEATHER_BOOTS, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.CHAINMAIL_BOOTS, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_BOOTS, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_BOOTS, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_BOOTS, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_BOOTS, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
