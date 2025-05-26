plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ecom"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ecom"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material) // Or replace this with direct version if needed
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.0")

    // Rounded ImageView
    implementation("com.makeramen:roundedimageview:2.3.0")

    // Material Search Bar
    implementation("com.github.mancj:MaterialSearchBar:0.8.5")

    // Optional: Circle Indicator (for viewpager indicators)
    implementation("me.relex:circleindicator:2.1.6")

    // Optional: Image Carousel
    implementation("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0")

    //for api
    implementation("com.android.volley:volley:1.2.1")


}
