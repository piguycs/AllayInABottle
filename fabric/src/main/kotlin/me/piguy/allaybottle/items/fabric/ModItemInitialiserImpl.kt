package me.piguy.allaybottle.items.fabric

import me.piguy.allaybottle.AllayBottle
import me.piguy.allaybottle.items.ModItemInitialiser
import me.piguy.allaybottle.items.custom.AllayBottleItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity


object ModItemInitialiserImpl {
  @JvmStatic
  fun registerOnPlatform() {
    ModItemInitialiser.ALLAY_BOTTLE = Registry.register(
      Registries.ITEM,
      Identifier(AllayBottle.MOD_ID, "allay_bottle"),
      AllayBottleItem(getSettings())
    )
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
      .register(ModifyEntries { entries: FabricItemGroupEntries ->
        entries.add(
          ModItemInitialiser.ALLAY_BOTTLE
        )
      })
  }

  private fun getSettings(): Item.Settings =
    FabricItemSettings()
      .maxCount(16)
      .recipeRemainder(Items.GLASS_BOTTLE)
      .rarity(Rarity.RARE)
}