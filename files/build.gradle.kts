plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.sonarqube") version "4.4.1.3373"
	id("jacoco")
}

group = "com.anikasystems"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-activemq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

jacoco {
    toolVersion = "0.8.7"
    //reportsDir = file("$buildDir/customJacocoReportDir")
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy("jacocoTestReport") // Ensure that the Jacoco report is always generated after tests run
}

tasks.named("jacocoTestReport", JacocoReport::class) {
    reports {
        xml.required = true // for SonarQube
        html.required = true // for humans
    }
}

sonar {
  properties {
    property("sonar.projectKey", "AnikaSystems_springboot-activemq_90def153-69ad-478c-9212-21f5f9e653a9")
    property("sonar.projectName", "springboot-activemq")
  }
}