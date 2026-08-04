plugins {
    id("java-library")
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(Integer.parseInt(project.property("java-version").toString()))
    }
}