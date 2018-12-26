rootProject.name = "garden-chain"

include("config-server", "eureka-server", "auth-service")

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> {
                    val kotlinVersion: String by settings
                    useVersion(kotlinVersion)
                }
                "org.jetbrains.kotlin.plugin.spring" -> {
                    val kotlinVersion: String by settings
                    useVersion(kotlinVersion)
                }
                "org.springframework.boot" -> {
                    val springBootPluginVersion: String by settings
                    useVersion(springBootPluginVersion)
                }
                "io.spring.dependency-management" -> {
                    val springDependencyManagementPluginVersion: String by settings
                    useVersion(springDependencyManagementPluginVersion)
                }
                "com.google.cloud.tools.jib" -> {
                    val jibPluginVersion: String by settings
                    useVersion(jibPluginVersion)
                }
            }
        }
    }
}