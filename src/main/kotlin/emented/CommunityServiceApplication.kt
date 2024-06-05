package emented

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableProcessApplication
class CommunityServiceApplication

fun main(args: Array<String>) {
    runApplication<CommunityServiceApplication>(*args)
}
