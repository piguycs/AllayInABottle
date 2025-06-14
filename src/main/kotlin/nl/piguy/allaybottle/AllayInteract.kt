package nl.piguy.allaybottle

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Hand
import nl.piguy.allaybottle.items.ModItems


object AllayInteract {
    fun playerAllayInteract(player: PlayerEntity, hand: Hand): Boolean {
        if (player.isSneaking && !player.world.isClient && playerHasBottle(player, hand)) {
            interact(player, hand)
            return true
        }

        return false
    }

    private fun playerHasBottle(player: PlayerEntity, hand: Hand): Boolean {
        return player.getStackInHand(hand).item == Items.GLASS_BOTTLE
    }

    private fun interact(player: PlayerEntity, hand: Hand) {
        val playerHandBottle = player.getStackInHand(hand)

        val allayBottle = ItemStack(ModItems.ALLAY_BOTTLE)
        Backports.giveOrDropStack(player, allayBottle)

        playerHandBottle.decrement(1)
    }
}