plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.example.uikitcomps"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Базовые AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Compose BOM — управляет версиями Compose-зависимостей ниже
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    // Compose UI
    implementation(libs.androidx.ui)                    // ← здесь Modifier
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    // Material3 — здесь Button, Text, Card и т.д.
    implementation(libs.androidx.material3)

    // Для @Preview в IDE
    debugImplementation(libs.androidx.ui.tooling)

    // Тесты
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "io.github.salomon264"

                artifactId = "uikitcomps"
                version = "1.0.2"

                from(components["release"])
            }
        }

        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/Salomon264/Preparing")

                credentials {
                    username = project.findProperty("gpr.user") as String?
                    password = project.findProperty("gpr.key") as String?
                }
            }
        }
    }
}