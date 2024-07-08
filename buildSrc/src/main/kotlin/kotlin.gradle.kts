
plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

tasks.test {
    failFast = true
    maxHeapSize = "2048m"
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        progressiveMode = true
        allWarningsAsErrors = true
    }
}
