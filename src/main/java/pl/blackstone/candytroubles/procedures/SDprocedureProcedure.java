package pl.blackstone.candytroubles.procedures;

import pl.blackstone.candytroubles.item.SweetDreamsDiscItem;
import pl.blackstone.candytroubles.CandytroublesModElements;
import pl.blackstone.candytroubles.CandytroublesMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@CandytroublesModElements.ModElement.Tag
public class SDprocedureProcedure extends CandytroublesModElements.ModElement {
	public SDprocedureProcedure(CandytroublesModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CandytroublesMod.LOGGER.warn("Failed to load dependency entity for procedure SDprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("minecraft:adventure/sleep_in_bed")))
						.isDone()
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SweetDreamsDiscItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Congratulations on getting Sweet Dreams! "), (false));
			}
		}
	}
}
