grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.repos.default = "crm"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn"
    repositories {
        grailsHome()
        grailsCentral()
        mavenRepo "http://labs.technipelago.se/repo/crm-releases-local/"
        mavenRepo "http://labs.technipelago.se/repo/plugins-releases-local/"
    }
    dependencies {
    }

    plugins {
        build(":tomcat:$grailsVersion",
                ":release:2.0.4") {
            export = false
        }
        runtime(":hibernate:$grailsVersion") {
            export = false
        }

        test(":spock:0.7") { export = false }
        test(":greenmail:1.3.2") { export = false }
        runtime ":mail:1.0"
        compile(":platform-core:1.0.M6") { excludes 'resources' }

        compile "grails.crm:crm-core:latest.integration"

        runtime ":text-template:latest.integration"
    }
}
