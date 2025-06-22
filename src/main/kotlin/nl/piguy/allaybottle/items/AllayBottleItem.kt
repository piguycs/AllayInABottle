package nl.piguy.allaybottle.items

import net.minecraft.component.DataComponentTypes
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.passive.AllayEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.Items
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos

class AllayBottleItem(settings: Settings) : Item(settings) {
    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        val hand = context.hand
        val user = context.player
        val world = context.world

        if (world != null && !world.isClient && user != null) {
            val direction = context.side
            val blockPos = context.blockPos
            val blockState = world.getBlockState(blockPos)
            val blockPos2: BlockPos =
                if (blockState.getCollisionShape(world, blockPos).isEmpty) {
                    blockPos
                } else blockPos.offset(direction)

            val allay = EntityType.ALLAY.spawn(
                world as ServerWorld,
                null,
                blockPos2,
                SpawnReason.TRIGGERED,
                false,
                false
            )

            if (allay != null) {
                setAllayName(allay, context.stack.customName)
            }


            val glassBottle = ItemStack(Items.GLASS_BOTTLE)

            if (!user.isCreative) {
                user.getStackInHand(hand)?.decrement(1)
                user.giveOrDropStack(glassBottle)
            }

            return ActionResult.CONSUME
        }

        return super.useOnBlock(context)
    }

    private fun setAllayName(allay: AllayEntity, name: Text?) {
        if (name != null) {
            allay.customName = name
        }
    }
}