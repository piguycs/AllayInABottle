package me.piguy.allaybottle

import me.piguy.allaybottle.items.ModItemInitialiser
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("UNUSED")
object AllayBottle : ModInitializer {
  var MOD_ID = "allaybottle"
  var LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

  override fun onInitialize() {
    ModItemInitialiser.registerItems()
  }
}