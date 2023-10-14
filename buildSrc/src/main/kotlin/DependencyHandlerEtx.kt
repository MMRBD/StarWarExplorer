import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}

fun DependencyHandler.androidTest(dependency: String) {
    add("androidTest", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}


