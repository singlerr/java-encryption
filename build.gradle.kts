plugins {
    id("java")
    id("com.diffplug.spotless") version "6.11.0"
    id("signing")
    `maven-publish`
}

val ossrhUsername:String by project
val ossrhPassword:String by project

group = "com.github.singlerr"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
}

java{
    withSourcesJar()
    withJavadocJar()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

spotless{
    java{
        target("src/*/java/**/*.java")
        importOrder()

        trimTrailingWhitespace()
        indentWithSpaces()
        indentWithTabs()

        endWithNewline()
        removeUnusedImports()
        formatAnnotations()

        palantirJavaFormat()

        licenseHeaderFile(file("LICENSE"))
    }
}

publishing{
    repositories {
        maven {
            name = "sonatype"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials{
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }

    publications{
        create<MavenPublication>("mavenJava"){
            from(components["java"])
            pom{
                name.set(rootProject.name)
                description.set("A simple java cipher lib.")
                url.set("https://github.com/singlerr/java-encryption")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("singlerr")
                        name.set("Ryu Seowoong")
                        email.set("singlerr@naver.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/singlerr/java-encryption.git")
                    developerConnection.set("scm:git:ssh://github.com/singlerr/java-encryption.git")
                    url.set("https://github.com/singlerr/java-encryption")
                }
            }
        }
    }
}