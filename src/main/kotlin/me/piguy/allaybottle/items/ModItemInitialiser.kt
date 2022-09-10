package me.piguy.allaybottle.items

import me.piguy.allaybottle.AllayBottle
import me.piguy.allaybottle.items.custom.AllayBottleItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.registry.Registry

object ModItemInitialiser {

  final val ALLAY_BOTTLE =
    registerItem(
      "allay_bottle",
      AllayBottleItem(FabricItemSettings()
        .maxCount(1)
        .recipeRemainder(Items.GLASS_BOTTLE)
        .group(ItemGroup.MISC)
        .rarity(Rarity.EPIC)
      )
    )

  fun registerItems() {
    AllayBottle.LOGGER.debug("Registering mod items for ${AllayBottle.MOD_ID}")
  }

  private fun registerItem(name: String, item: Item): Item {
    return Registry.register(Registry.ITEM, Identifier(AllayBottle.MOD_ID, name), item)
  }
}