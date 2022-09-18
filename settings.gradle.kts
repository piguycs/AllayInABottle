pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        mavenCentral()
        gradlePluginPortal()
    }
}

include("common")
include("fabric")
include("forge")

rootProject.name = "Allay-In-A-Bottle"