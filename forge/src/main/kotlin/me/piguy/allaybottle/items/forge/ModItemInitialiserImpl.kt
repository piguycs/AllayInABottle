package me.piguy.allaybottle.items.forge

import me.piguy.allaybottle.AllayBottle
import me.piguy.allaybottle.items.ModItemInitialiser
import me.piguy.allaybottle.items.custom.AllayBottleItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.Rarity
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItemInitialiserImpl {
  val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, AllayBottle.MOD_ID)

  private val ALLAY_BOTTLE_FORGE by REGISTRY.registerObject("allay_bottle") {
    // Made it so it will print log message
    AllayBottle.onInitialize()
    AllayBottleItem(getSettings()).also { ModItemInitialiser.ALLAY_BOTTLE = it }
  }
 
//  @SubscribeEvent
//  fun buildContents(event: CreativeModeTabEvent.BuildContents) {
//    if (event.tab == ItemGroups.TOOLS) {
//      event.accept { ALLAY_BOTTLE_FORGE }
//    }
//  }
  @JvmStatic
  fun registerOnPlatform() {
    // Nothing here :)

  }

  private fun getSettings(): Item.Settings =
    Item.Settings()
      .maxCount(16)
      .recipeRemainder(Items.GLASS_BOTTLE)
      .rarity(Rarity.RARE)

}