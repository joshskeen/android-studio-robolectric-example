![build status](https://travis-ci.org/mutexkid/android-studio-robolectric-example.svg)

## Android Studio Robolectric Test Example
--- 
This example project shows how to use robolectric, junit and assertJ with gradle-based Android Studio projects (as of Android Studio 1.2). Examine the top-level build.gradle and app/build.gradle files for a new project configuration gradle boilerplate. 

Make sure you're running the most recent version of Android Studio from the Canary Channel for this to work correctly (1.2 Beta as of today).

### To set up from a new Android Studio Project: 

your top-level build.gradle file should look like this: 

```javascript
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.1.0'
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
    compileSdkVersion 22
    buildToolsVersion "22.0.1"

    defaultConfig {
        applicationId "com.example.joshskeen.myapplication"
        minSdkVersion 16
        targetSdkVersion 22
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    testCompile 'org.easytesting:fest:1.0.16'
    testCompile 'com.squareup:fest-android:1.0.8'
    testCompile('org.robolectric:robolectric:3.0-rc2') {
        exclude group: 'commons-logging', module: 'commons-logging'
        exclude group: 'org.apache.httpcomponents', module: 'httpclient'
    }
}
```

2. Create directories matching src/test/java/ and add a package matching your project's packagename. eg src/test/java/com.example.joshskeen.myapplication
 <img src="https://www.evernote.com/shard/s313/sh/d69d9f94-76cb-42ac-858f-b6f7da68a6fb/f8d5f3ca3223094317d895c78cae5103/deep/0/TestMyActivity.java----app----android-studio-robolectric-example------code-foo-bar-android-studio-robolectric-example----Android-Studio-(Beta)-0.8.4.png" width="600">


4. click 'Sync Project with Gradle Files'
 <img src="https://www.evernote.com/shard/s313/sh/75d04b22-0ef0-449e-b137-e65dd4948865/28376be9739b21ca941d8fb6a4eeda88/deep/0/README.md----MyApplication----My-Application------AndroidStudioProjects-MyApplication----Android-Studio-(Beta)-0.8.1.png" width="600">


 
5. Select "Unit Tests" under "Build Variants"
 <img src="https://www.evernote.com/shard/s313/sh/560c4b5f-e70b-4800-b46f-bc1968618338/89c1e740e7134316961a103021daf1cb/deep/0/MyActivityTest.java---android-studio-robolectric-example------code-android-studio-robolectric-example-.png" width="600">
 

5. ctrl + click on the test and select Run > MyActivityTest. Make sure you select "Gradle" test (rather than unit), indicated by the gradle icon as seen here: <img
 src="https://www.evernote.com/shard/s313/sh/47697c52-1e33-4983-8ddd-65a3e69334c9/85c63c5315f32066f6bf5a2da55eacc4/deep/0/MyActivityTest.java---android-studio-robolectric-example------code-android-studio-robolectric-example-.png" width="600">


4. Write Robolectric Tests! For more intel on how to write tests using robolectric + fest, check out [http://blog.bignerdranch.com/2583-testing-the-android-way/](http://blog.bignerdranch.com/2583-testing-the-android-way/)


