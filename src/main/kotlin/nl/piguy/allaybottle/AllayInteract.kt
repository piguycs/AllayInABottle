package nl.piguy.allaybottle

import net.minecraft.core.component.DataComponents
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import nl.piguy.allaybottle.items.ModItems


object AllayInteract {
    fun playerAllayInteract(player: Player, hand: InteractionHand, allayName: Component?) : Boolean {
        if (player.isCrouching && !player.level().isClientSide && playerHasBottle(player, hand)) {
            interact(player, hand, allayName)

            return true
        }

        return false
    }

    private fun playerHasBottle(player: Player, hand: InteractionHand): Boolean {
        return player.getItemInHand(hand).item == Items.GLASS_BOTTLE
    }

    private fun interact(player: Player, hand: InteractionHand, allayName: Component?) {
        val playerHandBottle = player.getItemInHand(hand)

        val allayBottle = ItemStack(ModItems.ALLAY_BOTTLE)
        if (allayName != null) {
            allayBottle.set(DataComponents.CUSTOM_NAME, allayName)
        }

        player.handleExtraItemsCreatedOnUse(allayBottle)

        playerHandBottle.shrink(1)
    }
}
