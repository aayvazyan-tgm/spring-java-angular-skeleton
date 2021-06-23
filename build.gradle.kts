import com.moowork.gradle.node.npm.NpxTask

plugins {
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.github.node-gradle.node") version "2.2.0"
    id("java")
}

group = "at.oebb.openinnovation.parking-space-monitor"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

node {
    // Version of node to use.
    version = "14.17.0"
    npmVersion = "6.14.13"
    download = true
    workDir = file("${project.buildDir}/nodejs")
    npmWorkDir = file("${project.buildDir}/npm")
    nodeModulesDir = file("${project.projectDir}/web")
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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    val buildAngularApp = register<NpxTask>("buildAngularApp") {
        dependsOn("npmInstall")
        command = "ng"
        setArgs(listOf("build", "--prod"))
        inputs.files("package.json", "package-lock.json", "angular.json", "tsconfig.json", "tsconfig.app.json")
        inputs.dir("web/src")
        inputs.dir(fileTree("web/node_modules").exclude(".cache"))
        outputs.dir("web/dist")
    }

    val copyWeb = register<Sync>("copyWeb") {
        dependsOn(buildAngularApp)
        from("web/dist/web")
        into("src/main/resources/static")
    }

    "processResources" {
        dependsOn(copyWeb)
    }
    getByName<Delete>("clean") {
        delete.add("web/dist")
        delete.add("src/main/resources/static")
    }
}
