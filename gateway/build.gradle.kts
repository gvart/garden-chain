
import com.google.cloud.tools.jib.image.ImageFormat
import com.moowork.gradle.node.npm.NpmTask
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
    id("com.moowork.node") version "1.2.0"
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
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
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


node {
    version = "8.11.3"
    npmVersion = "6.4.0"
    download = true
    workDir = File("${project.buildDir}/node")
    nodeModulesDir = File("${project.projectDir}/src/main/webapp")
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
        ports = listOf("8080")
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
//    withType<NpmTask> {
//        setArgs(listOf("run", "build"))
//    }
    withType<Jar> {
        from("${project.projectDir}/src/main/webapp/dist/GardenChain") {
          into("static")
        }
       dependsOn("npm_run_build")
    }
}