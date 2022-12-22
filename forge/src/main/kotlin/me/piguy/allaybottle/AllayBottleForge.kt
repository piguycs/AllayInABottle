package me.piguy.allaybottle

import me.piguy.allaybottle.items.forge.ModItemInitialiserImpl
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(AllayBottle.MOD_ID)
class AllayBottleForge {

  init {
    ModItemInitialiserImpl.REGISTRY.register(MOD_BUS)

  }
}