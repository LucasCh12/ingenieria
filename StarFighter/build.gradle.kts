plugins {
    java
    application
    jacoco
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

// mainClassName = "tu.paquete.Main"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation ("org.easymock:easymock:5.1.0")

    // Cucumber
    testImplementation("org.junit.platform:junit-platform-suite:1.10.2")
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
}

tasks.test {
    useJUnitPlatform {
        testLogging {
            events("passed", "skipped", "failed")
            showExceptions = true
            showStackTraces = true
            showCauses = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
    
    // CONFIGURACIÓN CUCUMBER AGREGADA
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
    systemProperty("cucumber.plugin", "pretty, html:build/reports/cucumber/report.html")
    systemProperty("cucumber.glue", "ar.edu.unrc.dc.runners")
    
    // AGREGAR: Finalizar con jacocoTestReport
    finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("") // Configura tu clase principal aquí si es necesario
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    
    // AGREGAR: Configurar directorio de reportes
    reports.html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco/test/html"))
}