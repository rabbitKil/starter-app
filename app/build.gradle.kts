plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "healthstack.sample"
        minSdk = 29
        targetSdk = 31
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.UI
    }

    packagingOptions {
        resources {
            merges += "/META-INF/LICENSE.md"
            merges += "/META-INF/NOTICE.md"
        }
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation("io.s-healthstack:kit:0.9")
    implementation("io.s-healthstack:app-support:0.9")
    implementation("io.s-healthstack:healthdata-link:0.9")
    implementation("io.s-healthstack:healthconnect:0.9")
    implementation("io.s-healthstack:backend-integration:0.9")
    implementation("io.s-healthstack:healthstack-adapter:0.9")

    implementation(platform(AppDependencies.FIREBASE_BOM))
    implementation(AppDependencies.GOOGLE_HEALTH_CONNECT)
    implementation(AppDependencies.GOOGLE_HEALTH_DATA)
    implementation(AppDependencies.authImplLibs)
    implementation(AppDependencies.composeImplLibs)
    implementation(AppDependencies.hiltImplLibs)
    implementation(AppDependencies.healthDataImplLibs)

    kapt(AppDependencies.hiltKaptLibs)
}
