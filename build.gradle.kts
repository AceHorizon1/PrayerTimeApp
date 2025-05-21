buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Suppress CSS appearance property warning in build reports
tasks.withType<com.android.build.gradle.internal.tasks.factory.dependsOn.TaskFactory.TaskConfigurator> {
    doLast {
        val reportDir = project.buildDir.resolve("reports/problems")
        if (reportDir.exists()) {
            reportDir.walk()
                .filter { it.name == "problems-report.html" }
                .forEach { file ->
                    val content = file.readText()
                    file.writeText(content.replace(
                        "-webkit-appearance: button",
                        "-webkit-appearance: button; appearance: button"
                    ))
                }
        }
    }
} 