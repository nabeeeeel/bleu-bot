import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.nabeeeeel"
version = "0.0.1a"



plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
    maven{
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.21.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"


}