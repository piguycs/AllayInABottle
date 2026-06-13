package nl.piguy.allaybottle.items

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents.ModifyOutput
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput
import net.minecraft.world.item.Item
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.Identifier
import nl.piguy.allaybottle.AllayInABottle.MOD_ID


object ModItems {
    val ALLAY_BOTTLE = register("allay_bottle", ::AllayBottleItem, Item.Properties())

    fun initialise() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register(ModifyOutput { itemGroup: FabricCreativeModeTabOutput -> itemGroup.accept(ALLAY_BOTTLE) })
    }

    private fun register(name: String, itemFactory: (Item.Properties) -> Item, settings: Item.Properties): Item {
        val key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name))
        val item = itemFactory.apply { settings.setId(key) }(settings)

        Registry.register(BuiltInRegistries.ITEM, key, item)

        return item
    }
}