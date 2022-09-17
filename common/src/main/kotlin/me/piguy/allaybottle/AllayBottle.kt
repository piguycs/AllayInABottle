package me.piguy.allaybottle

import me.piguy.allaybottle.items.ModItemInitialiser
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object AllayBottle {
    const val MOD_ID = "allaybottle"
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    fun onInitialize() {
        ModItemInitialiser.registerItems()
    }
}