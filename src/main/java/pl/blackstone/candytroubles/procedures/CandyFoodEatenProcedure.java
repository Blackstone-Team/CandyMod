package pl.blackstone.candytroubles.procedures;

import pl.blackstone.candytroubles.CandytroublesModElements;
import pl.blackstone.candytroubles.CandytroublesMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@CandytroublesModElements.ModElement.Tag
public class CandyFoodEatenProcedure extends CandytroublesModElements.ModElement {
	public CandyFoodEatenProcedure(CandytroublesModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CandytroublesMod.LOGGER.warn("Failed to load dependency entity for procedure CandyFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 320, (int) 1, (false), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 460, (int) 4, (false), (true)));
	}
}
