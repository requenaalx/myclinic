
plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {

    fun plugin(dependency: PluginDependency) {
        val id = dependency.pluginId
        val version = dependency.version.requiredVersion
        implementation("$id:$id.gradle.plugin:$version")
    }

    plugin(libs.plugins.kover.get())
    plugin(libs.plugins.ktlint.get())
    plugin(libs.plugins.quarkus.get())
    plugin(libs.plugins.kotlin.jvm.get())
    plugin(libs.plugins.kotlin.serialization.get())
}
