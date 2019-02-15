import com.google.cloud.tools.jib.image.ImageFormat
import java.net.URI
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springCloudVersion: String by project
val logstashEncodeVersion: String by project
val testContainersVersion: String by project
val jaxbApiVersion: String by project
val javaxActivationVersion: String by project

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
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-config-client")

    //Tracing
    implementation("org.springframework.cloud:spring-cloud-starter-zipkin")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    //implementation("net.logstash.logback:logstash-logback-encoder:$logstashEncodeVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
    testCompile("org.testcontainers:testcontainers:$testContainersVersion")
    testCompile("org.testcontainers:junit-jupiter:$testContainersVersion")
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
        ports = listOf("8100")
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