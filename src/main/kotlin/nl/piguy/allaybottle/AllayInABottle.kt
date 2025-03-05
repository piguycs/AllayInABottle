package nl.piguy.allaybottle

import net.fabricmc.api.ModInitializer
import nl.piguy.allaybottle.items.ModItems
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object AllayInABottle : ModInitializer {
	const val MOD_ID = "allaybottle"
	val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)


	override fun onInitialize() {
		LOGGER.info("Hello Fabric world!")
		ModItems.initialise()
	}
}