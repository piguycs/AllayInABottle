package nl.piguy.allaybottle.items

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import nl.piguy.allaybottle.AllayInABottle.MOD_ID


object ModItems {
    val ALLAY_BOTTLE = register(AllayBottleItem(Item.Settings()), "allay_bottle")

    fun initialise() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(ModifyEntries { itemGroup: FabricItemGroupEntries -> itemGroup.add(ALLAY_BOTTLE) })
    }

    private fun register(item: Item?, id: String): Item? {
        // Create the identifier for the item.
        val itemID = Identifier.of(MOD_ID, id)

        // Register the item.
        val registeredItem = Registry.register<Item?, Item?>(Registries.ITEM, itemID, item)

        // Return the registered item!
        return registeredItem
    }
}