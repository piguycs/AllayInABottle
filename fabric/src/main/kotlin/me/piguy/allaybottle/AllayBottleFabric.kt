package me.piguy.allaybottle

import net.fabricmc.api.ModInitializer

class AllayBottleFabric : ModInitializer {
    override fun onInitialize() {
        AllayBottle.onInitialize()
    }
}