package me.piguy.allaybottle.items.forge

import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.util.Rarity

object ModItemInitialiserImpl {
    @JvmStatic
    fun registerOnPlatform(): Item.Settings {
        return Item.Settings()
            .maxCount(16)
            .recipeRemainder(Items.GLASS_BOTTLE)
            .group(ItemGroup.MISC)
            .rarity(Rarity.RARE)
    }
}