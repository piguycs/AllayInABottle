package me.piguy.allaybottle.mixins;

import me.piguy.allaybottle.items.ModItemInitialiser;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AllayEntity.class)
public abstract class AllayMixin extends PathAwareEntity {
    @Shadow
    public abstract void writeCustomDataToNbt(NbtCompound nbt);

    protected AllayMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    protected void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.isSneaking() && !player.getWorld().isClient && checkHand(player, hand)) {

            ItemStack playerHandBottle = player.getStackInHand(hand);
            ItemStack allayBottle = new ItemStack(ModItemInitialiser.INSTANCE.getALLAY_BOTTLE());
            ItemStack allayHandItem = this.getStackInHand(Hand.MAIN_HAND);

            player.giveItemStack(allayBottle);
            player.giveItemStack(allayHandItem);
            playerHandBottle.decrement(1);

            // despawns the entity
            // a method from PathAwareEntity
            this.discard();
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    private boolean checkHand(PlayerEntity player, Hand hand) {
        return player.getStackInHand(hand).getItem() == Items.GLASS_BOTTLE;
    }
}
