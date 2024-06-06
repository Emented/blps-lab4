package emented.delegate.comment

import emented.service.CommentService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class UpdateCommentRequestProcessor(
    private val runtimeService: RuntimeService,
    private val commentService: CommentService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        var userId = delegateExecution.processEngineServices.identityService.currentAuthentication.userId
        if (userId == "guest") {
            runtimeService.deleteProcessInstance(delegateExecution.processInstanceId, "Guest cannot edit comments!")
            return
        }

        val groups = delegateExecution.processEngineServices.identityService.currentAuthentication.groupIds

        val isModerator = groups.contains("moderators") || groups.contains("camunda-admin")

        val commentId = delegateExecution.getVariable("comment_id_update") as Long
        val commentText = delegateExecution.getVariable("comment_text_update").toString()

        if (userId == "emented") {
            userId = "0"
        }

        val updateResult = commentService.updateCommentText(
            commentId,
            userId.toLong(),
            commentText,
            isModerator,
        )

        delegateExecution.setVariable(
            "update_result",
            if (updateResult) "Комментарий успешно обновлен!" else "Не удалось обновить комментарий!"
        )
    }
}