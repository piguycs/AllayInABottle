package nl.piguy.allaybottle

import net.minecraft.component.DataComponentTypes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.text.Text
import net.minecraft.util.Hand
import nl.piguy.allaybottle.items.ModItems


object AllayInteract {
    fun playerAllayInteract(player: PlayerEntity, hand: Hand, allayName: Text?) : Boolean {
        if (player.isSneaking && !player.entityWorld.isClient && playerHasBottle(player, hand)) {
            interact(player, hand, allayName)

            return true
        }

        return false
    }

    private fun playerHasBottle(player: PlayerEntity, hand: Hand): Boolean {
        return player.getStackInHand(hand).item == Items.GLASS_BOTTLE
    }

    private fun interact(player: PlayerEntity, hand: Hand, allayName: Text?) {
        val playerHandBottle = player.getStackInHand(hand)

        val allayBottle = ItemStack(ModItems.ALLAY_BOTTLE)
        if (allayName != null) {
            allayBottle.set(DataComponentTypes.CUSTOM_NAME, allayName)
        }

        player.giveOrDropStack(allayBottle)

        playerHandBottle.decrement(1)
    }
}
