plugins {
    ktlint
    quarkus
    kotlin
    kover
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(libs.jdbi)
    implementation(libs.flyway.mysql)
    implementation(libs.kotlinx.serialization.json)

    implementation(enforcedPlatform(libs.quarkus.bom))
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-jdbc-mysql")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-flyway")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-rest-kotlin-serialization")
    implementation("io.quarkus:quarkus-cache")

    testImplementation(kotlin("test"))
    testImplementation(libs.mockk)
    testImplementation(libs.test.mysql)
    testImplementation(libs.rest.assured)
    testImplementation(libs.kotest)
    testImplementation("io.quarkus:quarkus-junit5")
}
