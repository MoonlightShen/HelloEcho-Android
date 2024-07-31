plugins {
    id("com.android.application")
    id("org.greenrobot.greendao")
    id("kotlin-android")
}

greendao {
    schemaVersion =1 //数据库版本号
    daoPackage = "com.echo.datatag3.database"
    generateTests =false //设置为true以自动生成单元测试。
}

android {
    namespace = "com.echo.hello"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.echo.hello"
        minSdk = 31
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dataBinding{
        enable = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree("libs"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.20")

    //数据库框架 GreenDAO
    implementation("org.greenrobot:greendao:3.3.0")
    implementation("org.greenrobot:greendao-generator:3.3.0")

    //序列化工具 Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //网络请求框架
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    //图片加载框架
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //权限请求框架
    implementation("com.github.getActivity:XXPermissions:20.0")

    //编码检测
    implementation("com.github.albfernandez:juniversalchardet:2.4.0")

    /////////////////////////UI

    //多状态布局
    implementation("com.classic.common:multiple-status-view:1.7")

    //智能刷新
    implementation("io.github.scwang90:refresh-layout-kernel:2.1.0")
    implementation("io.github.scwang90:refresh-header-classics:2.1.0")
    implementation("io.github.scwang90:refresh-footer-classics:2.1.0")

    //XUI
    implementation("com.github.xuexiangjys:XUI:1.2.1")

    //通用标题栏
    implementation("com.github.getActivity:TitleBar:10.5")

    //标题栏
    implementation("com.wuhenzhizao:titlebar:1.2.0")

    //Material风格输入框
    implementation("com.rengwuxian.materialedittext:library:2.1.4")

    //对话框
    implementation("com.afollestad.material-dialogs:core:3.3.0")
    implementation("com.afollestad.material-dialogs:input:3.3.0")
    implementation("com.afollestad.material-dialogs:datetime:3.3.0")
    implementation("com.afollestad.material-dialogs:bottomsheets:3.3.0")

    //图表
    implementation("com.github.AnyChart:AnyChart-Android:1.1.5")

}

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.aliyun.com/repository/google")
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    maven("https://maven.aliyun.com/repository/public")
    maven("https://maven.aliyun.com/repository/jcenter")
}