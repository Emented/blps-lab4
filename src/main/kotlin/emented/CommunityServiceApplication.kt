package emented

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
@EnableProcessApplication
class CommunityServiceApplication {

    @Autowired
    private lateinit var runtimeService: RuntimeService

    @EventListener
    private fun processPostDeploy(event: PostDeployEvent) {
        runtimeService.startProcessInstanceByKey("init_base_roles")
    }
}

fun main(args: Array<String>) {
    runApplication<CommunityServiceApplication>(*args)
}
