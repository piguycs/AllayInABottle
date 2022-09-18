package me.piguy.allaybottle.items

import dev.architectury.injectables.annotations.ExpectPlatform
import me.piguy.allaybottle.AllayBottle
import me.piguy.allaybottle.items.custom.AllayBottleItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItemInitialiser {

    @ExpectPlatform
    @JvmStatic
    fun registerOnPlatform(): Item.Settings {
        throw AssertionError()
    }

    val ALLAY_BOTTLE =
        registerItem(
            "allay_bottle",
            AllayBottleItem(registerOnPlatform())
        )

    fun registerItems() {
        AllayBottle.LOGGER.debug("Registering mod items for ${AllayBottle.MOD_ID}")
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier(AllayBottle.MOD_ID, name), item)
    }
}