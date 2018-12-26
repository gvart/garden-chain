
import com.google.cloud.tools.jib.image.ImageFormat
import java.net.URI
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springCloudVersion: String by project

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("com.google.cloud.tools.jib")
    jacoco
}

repositories {
    mavenCentral()
    maven {
        url = URI("http://repo.spring.io/milestone")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
    implementation("org.springframework.cloud:spring-cloud-config-client")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

jib {
    from {
        image = "openjdk:11-jre-slim"
    }
    to {
        image = project.name
        tags = setOf("1.0.0", "latest")

    }
    container {
        jvmFlags = listOf("-Xms512m")
        ports = listOf("8761")
        format = ImageFormat.OCI
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}