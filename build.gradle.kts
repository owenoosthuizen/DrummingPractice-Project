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
    // Kotlin test
    testImplementation(kotlin("test"))

    // Logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("org.slf4j:slf4j-simple:2.0.16")

    // XML + JSON persistence
    implementation("com.thoughtworks.xstream:xstream:1.4.21")
    implementation("org.codehaus.jettison:jettison:1.5.4")
}

tasks.test {
    useJUnitPlatform()
}