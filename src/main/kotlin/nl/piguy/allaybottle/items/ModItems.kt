package nl.piguy.allaybottle.items

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import nl.piguy.allaybottle.AllayInABottle.MOD_ID


object ModItems {
    val ALLAY_BOTTLE = register("allay_bottle", ::AllayBottleItem, Item.Settings())

    fun initialise() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(ModifyEntries { itemGroup: FabricItemGroupEntries -> itemGroup.add(ALLAY_BOTTLE) })
    }

    private fun register(name: String, itemFactory: (Item.Settings) -> Item, settings: Item.Settings): Item {
        val key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name))
        val item = itemFactory.apply { settings.registryKey(key) }(settings)

        Registry.register(Registries.ITEM, key, item)

        return item
    }
}