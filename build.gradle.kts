plugins {
    kotlin("jvm") version "1.5.30"
}

group = "me.nabeel"
version = "0.0.2"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.23.0-SNAPSHOT")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "13"
}