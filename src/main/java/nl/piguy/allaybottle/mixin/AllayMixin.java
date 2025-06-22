package nl.piguy.allaybottle.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import nl.piguy.allaybottle.AllayInteract;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AllayEntity.class)
public class AllayMixin extends PathAwareEntity {
	protected AllayMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
	protected void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
		@Nullable
		Text allayName = this.getCustomName();

		boolean interact = AllayInteract.INSTANCE.playerAllayInteract(player, hand, allayName);

		if (interact) {
			ItemStack stack = this.getStackInHand(Hand.MAIN_HAND);
			player.giveItemStack(stack);

			this.discard();
			cir.setReturnValue(ActionResult.SUCCESS);
		}
	}
}
