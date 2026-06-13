package nl.piguy.allaybottle.items

import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntitySpawnReason
import net.minecraft.world.entity.animal.allay.Allay
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.item.Items
import net.minecraft.server.level.ServerLevel
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionResult
import net.minecraft.core.BlockPos

class AllayBottleItem(settings: Properties) : Item(settings) {
    override fun useOn(context: UseOnContext): InteractionResult {
        val hand = context.hand
        val user = context.player
        val world = context.level

        if (world != null && !world.isClientSide && user != null) {
            val direction = context.clickedFace
            val blockPos = context.clickedPos
            val blockState = world.getBlockState(blockPos)
            val blockPos2: BlockPos =
                if (blockState.getCollisionShape(world, blockPos).isEmpty) {
                    blockPos
                } else blockPos.offset(direction.unitVec3i)

            val allay = EntityType.ALLAY.spawn(
                world as ServerLevel,
                null,
                blockPos2,
                EntitySpawnReason.TRIGGERED,
                false,
                false
            )

            if (allay != null) {
                setAllayName(allay, context.itemInHand.customName)
            }


            val glassBottle = ItemStack(Items.GLASS_BOTTLE)

            if (!user.isCreative) {
                user.getItemInHand(hand)?.shrink(1)
                user.handleExtraItemsCreatedOnUse(glassBottle)
            }

            return InteractionResult.CONSUME
        }

        return super.useOn(context)
    }

    private fun setAllayName(allay: Allay, name: Component?) {
        if (name != null) {
            allay.customName = name
        }
    }
}