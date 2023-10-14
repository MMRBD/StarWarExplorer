import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    object AndroidCore {
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.9.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2"
        const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"

        private const val navigation = "2.7.4"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigation"
    }

    object Hilt {
        private const val version = "2.48.1"

        const val hiltAndreoid = "com.google.dagger:hilt-android:$version"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitCoverter = "com.squareup.retrofit2:converter-gson:$version"

//        implementation("com.squareup.retrofit2:retrofit:2.9.0")
//        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//        implementation("com.squareup.okhttp3:okhttp:4.11.0")
//        implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")


    }

    object OkHttp {
        private const val version = "4.11.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"

    }

    object Fragment {
        private const val version = "1.6.1"
        const val fragment = "androidx.fragment:fragment-ktx:$version"
        const val fragmentDebugIm = "androidx.fragment:fragment-testing:$version"
    }

    object Room {
        private const val version = "2.5.2"
        const val room = "androidx.room:room-ktx:$version"
        const val roomRuntime = "androidx.room:room-runtime:$version"

        //        const val roomRuntimeAnnotation = "androidx.room:room-compiler:$version"
        const val roomTest = "androidx.room:room-testing:$version"
        const val roomKapt = "androidx.room:room-compiler:$version"
    }
}

fun DependencyHandler.fragment() {
    implementation(Dependencies.Fragment.fragment)
    debugImplementation(Dependencies.Fragment.fragmentDebugIm)
}


fun DependencyHandler.room() {
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.roomRuntime)
    testImplementation(Dependencies.Room.roomTest)
    kapt(Dependencies.Room.roomKapt)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.Hilt.hiltAndreoid)
    kapt(Dependencies.Hilt.hiltKapt)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitCoverter)
}

fun DependencyHandler.okHttp() {
    implementation(Dependencies.OkHttp.okhttp)
    implementation(Dependencies.OkHttp.interceptor)
}

