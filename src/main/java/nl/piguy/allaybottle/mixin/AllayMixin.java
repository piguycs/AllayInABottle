package nl.piguy.allaybottle.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import nl.piguy.allaybottle.AllayInteract;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Allay.class)
public class AllayMixin extends PathfinderMob {
	protected AllayMixin(EntityType<? extends PathfinderMob> entityType, Level world) {
		super(entityType, world);
	}

	@Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
	protected void interactMob(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
		@Nullable
		Component allayName = this.getCustomName();

		boolean interact = AllayInteract.INSTANCE.playerAllayInteract(player, hand, allayName);

		if (interact) {
			ItemStack stack = this.getItemInHand(InteractionHand.MAIN_HAND);
			player.addItem(stack);

			this.discard();
			cir.setReturnValue(InteractionResult.SUCCESS);
		}
	}
}
