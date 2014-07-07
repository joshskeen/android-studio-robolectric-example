## Android Studio Robolectric Test Example
--- 
This example project shows how to use robolectric, junit and fest with gradle-based Android Studio projects (as of Android Studio 0.8.1). Examine the top-level build.gradle and app/build.gradle files for a new project configuration gradle boilerplate. 

Uses :

- [Android Unit Test](https://github.com/JCAndKSolutions/android-unit-test)  
- [Android Studio Unit Test](https://github.com/evant/android-studio-unit-test-plugin) 

To run the tests from Android Studio rather than ``gradlew``, first install
- Install [Android Studio Unit Test](https://github.com/evant/android-studio-unit-test-plugin) plugin to Android Studio under plugins:

<img src="https://www.evernote.com/shard/s313/sh/fd96c364-d3f7-44bf-b47f-a92a120a2b31/05956583f739e98b5c3e40242bcae820/deep/0/Preferences-and-TestMyActivity.java----app----My-Application------AndroidStudioProjects-MyApplication----Android-Studio-(Beta)-0.8.1.png" width="600">

### To set up from a new Android Studio Project: 

your top-level build.gradle file should look like this: 

```javascript
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.12.+'
        classpath 'com.github.jcandksolutions.gradle:android-unit-test:+'
    }
}

allprojects {
    repositories {
        jcenter()
    }
}
```

your app/build.gradle file should look like this: 

```javascript
apply plugin: 'com.android.application'

android {
    compileSdkVersion 19
    buildToolsVersion "19.1.0"

    defaultConfig {
        applicationId "com.example.joshskeen.myapplication"
        minSdkVersion 14
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            runProguard false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    sourceSets {
        instrumentTest.setRoot('src/test')
    }
}

apply plugin: 'android-unit-test'

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile 'org.easytesting:fest:1.0.16'
    testCompile 'junit:junit:4.+'
    testCompile 'org.robolectric:robolectric:2.3'
    testCompile 'com.squareup:fest-android:1.0.8'
}
```


2. Create directories matching src/test/java/ and add a package matching your project's packagename. eg src/test/java/com.joshskeen.foobar

1. Install [Android Studio Unit Test](https://github.com/evant/android-studio-unit-test-plugin) plugin to Android Studio under Preferences > Plugins. 

3. You may need to restart Android Studio to allow the android studio unit test plugin to see src/test as a test directory. 

4. Write Robolectric Tests! For more intel on how to write tests using robolectric + fest, check out [blog.bignerdranch.com/2583-testing-the-android-way/](blog.bignerdranch.com/2583-testing-the-android-way/)


