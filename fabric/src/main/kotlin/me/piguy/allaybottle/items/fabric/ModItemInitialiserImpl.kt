package me.piguy.allaybottle.items.fabric

import me.piguy.allaybottle.AllayBottle
import me.piguy.allaybottle.items.ModItemInitialiser
import me.piguy.allaybottle.items.custom.AllayBottleItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.registry.Registry

object ModItemInitialiserImpl {
    @JvmStatic
    fun registerOnPlatform() {
        ModItemInitialiser.ALLAY_BOTTLE = Registry.register(
            Registry.ITEM,
            Identifier(AllayBottle.MOD_ID, "allay_bottle"),
            AllayBottleItem(getSettings())
        )
    }

    private fun getSettings(): Item.Settings =
        FabricItemSettings()
            .maxCount(16)
            .recipeRemainder(Items.GLASS_BOTTLE)
            .group(ItemGroup.MISC)
            .rarity(Rarity.RARE)
}