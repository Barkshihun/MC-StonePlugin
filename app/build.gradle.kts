plugins {
    application
}

repositories {
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("com.google.guava:guava:30.1.1-jre")
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
}

application {
    mainClass.set("io.github.barkshihun.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

task<Exec>("do"){
    dependsOn("clean")
    dependsOn("jar")
    workingDir("../")
    commandLine("cmd", "/c", "move.bat")
    doLast{
        exec{
            workingDir("../")
            commandLine("cmd", "/c", "server.bat")
        }
    }
}

tasks.named<Jar>("jar") {
	archiveFileName.set("StonePlugin.jar")
}