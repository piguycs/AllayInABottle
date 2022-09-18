package me.piguy.allaybottle.items

import dev.architectury.injectables.annotations.ExpectPlatform
import me.piguy.allaybottle.AllayBottle
import net.minecraft.item.Item

object ModItemInitialiser {

    @ExpectPlatform
    @JvmStatic
    fun registerOnPlatform() {
        throw AssertionError()
    }

    lateinit var ALLAY_BOTTLE: Item

    fun registerItems() {
        AllayBottle.LOGGER.info("Registering mod items")
        registerOnPlatform()
    }
}