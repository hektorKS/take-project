/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  java
  application
  id("org.springframework.boot") version "2.1.3.RELEASE"
}

private object Versions {
  const val springBoot = "2.1.3.RELEASE"
  const val hikariCP = "3.3.1"
  const val myBatis = "1.3.2"
  const val mysqlConnector = "8.0.15"
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}")
  implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:${Versions.myBatis}")
  implementation("com.zaxxer:HikariCP:${Versions.hikariCP}")
  implementation("org.json:json:20180130")
  runtimeOnly("mysql:mysql-connector-java:${Versions.mysqlConnector}")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
  getByName<Wrapper>("wrapper") {
    gradleVersion = "5.2"
  }
  getByName<BootJar>("bootJar") {
    baseName = "take-backend"
    version = ""
    mainClassName = "com.hektorks.TakeServiceApplication"
    
    destinationDir = file("$rootDir/build")
  }
}