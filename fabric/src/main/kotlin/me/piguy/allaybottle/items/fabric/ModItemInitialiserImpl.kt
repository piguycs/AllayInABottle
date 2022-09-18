package me.piguy.allaybottle.items.fabric

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.util.Rarity

object ModItemInitialiserImpl {
    @JvmStatic
    fun registerOnPlatform(): Item.Settings {
        return FabricItemSettings()
            .maxCount(16)
            .recipeRemainder(Items.GLASS_BOTTLE)
            .group(ItemGroup.MISC)
            .rarity(Rarity.RARE)
    }
}