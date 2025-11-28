plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "ie.yourname"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.thoughtworks.xstream:xstream:1.4.21")
    implementation("org.codehaus.jettison:jettison:1.5.4")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

//ai was used for this since i got an error when running main
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.test {
    useJUnitPlatform()
}
