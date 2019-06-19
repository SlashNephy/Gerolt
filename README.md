# Gerolt: A toolkit of FINAL FANTASY XIV for Kotlin

[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.31-blue.svg)](https://kotlinlang.org)
[![Stable](https://img.shields.io/bintray/v/nephyproject/stable/Gerolt.svg?label=stable)](https://github.com/NephyProject/Gerolt/releases/latest)
[![Dev](https://img.shields.io/bintray/v/nephyproject/dev/Gerolt.svg?label=dev)](https://bintray.com/nephyproject/dev/Gerolt/_latestVersion)
[![License](https://img.shields.io/github/license/NephyProject/Gerolt.svg)](https://github.com/NephyProject/Gerolt/blob/master/LICENSE)
[![Issues](https://img.shields.io/github/issues/NephyProject/Gerolt.svg)](https://github.com/NephyProject/Gerolt/issues)
[![Pull Requests](https://img.shields.io/github/issues-pr/NephyProject/Gerolt.svg)](https://github.com/NephyProject/Gerolt/pulls)

* Conversion between Eorzea Time & Earth Time.
* Weather forecasts.

KDoc is available at [docs.nephy.jp](https://docs.nephy.jp/gerolt).

## Quick example

```kotlin
fun main() {
    // Gets current Eorzea Time
    val time = EorzeaTime.now()
    
    // Eorzea Time to Earth Time (java.time.Instant)
    val earthTime = time.toEarthTime()
    
    // Eorzea zones enum
    val zone = EorzeaZone.TheLavenderBeds
    
    // Forecasts the weather at The Lavender Beds at [time].
    val weather = time.weather(zone)
}
```

More examples of Gerolt can be found at [Wiki](https://github.com/NephyProject/Gerolt/wiki/Sample). Please feel free to create [new issue](https://github.com/NephyProject/Gerolt/issues/new/choose) if you have any questions.

## Setup

Latest Gerolt version is [![Stable](https://img.shields.io/bintray/v/nephyproject/stable/Gerolt.svg?label=stable)](https://github.com/NephyProject/Gerolt/releases/latest) or [![Dev](https://img.shields.io/bintray/v/nephyproject/dev/Gerolt.svg?label=dev)](https://bintray.com/nephyproject/dev/Gerolt/_latestVersion).  

Stable releases are available at [Bintray](https://bintray.com/nephyproject/stable/Gerolt). EAP builds are also available ([Dev Repository](https://bintray.com/nephyproject/dev/Gerolt)). Every commit is published as EAP build.  

### Gradle Kotlin DSL

We recommend using Gradle Kotlin DSL instead of classic build.gradle.  

#### build.gradle.kts

```kotlin
val geroltVersion = "1.0.0"

plugins { 
    kotlin("jvm") version "1.3.31"
}

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/nephyproject/stable")
    // Or dev repository
    // maven(url = "https://dl.bintray.com/nephyproject/dev")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("jp.nephy:gerolt:$geroltVersion")
}
```

### Gradle

#### build.gradle

```groovy
buildscript {
    ext.gerolt_version = "1.0.0"
    ext.kotlin_version = "1.3.31"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

repositories {
    mavenCentral()
    jcenter()
    maven { url "https://dl.bintray.com/nephyproject/stable" } 
    // Or dev repository
    // maven { url "https://dl.bintray.com/nephyproject/dev" }
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    implementation "jp.nephy:gerolt:$gerolt_version"
}
```

## License

Gerolt is provided under MIT license. A copy of MIT license of Nephy Project is available [here](https://nephy.jp/license/mit).

Copyright (c) 2017-2019 Nephy Project.
