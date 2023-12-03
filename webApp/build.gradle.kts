import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

val ktorVersion = extra["ktor.version"]

val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
    from(project(":webApp").file("src/wasmJsMain/resources"))
    into("build/processedResources/wasmJs/main")
}

afterEvaluate {
    project.tasks.getByName("wasmJsProcessResources").finalizedBy(copyWasmResources)
}

kotlin {
    js(IR) {
        moduleName = "composeweb"
        browser {
            commonWebpackConfig {
                outputFileName = "composeweb.js"
            }
        }
        binaries.executable()
    }

    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeweb"
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    // Uncomment and configure this if you want to open a browser different from the system default 
                    // open = mapOf(
                    //     "app" to mapOf(
                    //         "name" to "google chrome"
                    //     )
                    // )

                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path + "/webApp/")
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsWasmMain by creating {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(compose.materialIconsExtended)
            }

        }
        val jsMain by getting {
            dependsOn(jsWasmMain)
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
        val wasmJsMain by getting {
            dependsOn(jsWasmMain)
        }
    }
}

compose.experimental {
    web.application {}
}
