plugins {
    `slappy-bukkit-release`
    alias(libs.plugins.git.version)
}

project.description = project.property("plugin-description").toString()

dependencies {
    compileOnly(libs.spigot.api)
}

@Suppress("UNCHECKED_CAST")
val gitVersion = extra["gitVersion"] as groovy.lang.Closure<String>

allprojects {
    version = gitVersion()
}