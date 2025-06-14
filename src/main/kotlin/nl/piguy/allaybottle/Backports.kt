package nl.piguy.allaybottle

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack

object Backports {
    fun giveOrDropStack(player: PlayerEntity, stack: ItemStack?) {
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false)
        }
    }
}