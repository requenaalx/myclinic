
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.tasks.BaseKtLintCheckTask

plugins {
    id("org.jlleitschuh.gradle.ktlint")
}

configure<KtlintExtension> {
    filter {
        include("**/kotlin/**")
    }
}

tasks.withType<BaseKtLintCheckTask> {
    val main = tasks.matching { it.name.contains("compileQuarkusGeneratedSourcesJava") }
    val test = tasks.matching { it.name.contains("compileQuarkusTestGeneratedSourcesJava") }
    dependsOn(main, test)
}
