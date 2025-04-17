plugins {
    id("czl.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":czl-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.czl.api.example.Main"
}
