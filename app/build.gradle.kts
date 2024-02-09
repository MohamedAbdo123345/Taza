plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    ////to args
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.taza"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.taza"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //navigation
    implementation("androidx.navigation:navigation-fragment:2.5.3")
    implementation ("androidx.navigation:navigation-ui:2.5.3")
    ////lottie
    implementation ("com.airbnb.android:lottie:3.4.0")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.4.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")
    //out
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    //for image
    implementation ("com.makeramen:roundedimageview:2.3.0")
    //for glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    // retrofit2 RXJava3 adapter

    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    //RXJava3
//
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.6")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation("androidx.room:room-rxjava3:$2.6.1")
    ///xml
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //xml vedio
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:11.1.0")
    //room
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    implementation ("com.google.firebase:firebase-database")
    implementation ("com.google.firebase:firebase-firestore:24.4.2")
    implementation ("com.google.firebase:firebase-analytics")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    //onbording
    implementation ("com.ramotion.paperonboarding:paper-onboarding:1.1.3")


}