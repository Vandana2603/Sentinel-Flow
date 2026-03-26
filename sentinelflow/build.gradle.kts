plugins {
    kotlin("jvm") version "1.9.0"
    id("org.springframework.boot") version "3.2.2"
    kotlin("plugin.spring") version "1.9.0"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    google()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.2.2")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.2.2")
implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")  // last stable 0.8.x
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3") // stable
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")
}