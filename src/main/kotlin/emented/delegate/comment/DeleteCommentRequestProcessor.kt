package emented.delegate.comment

import emented.service.CommentService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DeleteCommentRequestProcessor(
    private val runtimeService: RuntimeService,
    private val commentService: CommentService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        var userId = delegateExecution.processEngineServices.identityService.currentAuthentication.userId
        if (userId == "guest") {
            runtimeService.deleteProcessInstance(delegateExecution.processInstanceId, "Guest cannot delete comments!")
            return
        }

        val groups = delegateExecution.processEngineServices.identityService.currentAuthentication.groupIds

        val isModerator = groups.contains("moderators") || groups.contains("camunda-admin")

        val commentId = delegateExecution.getVariable("comment_id_delete") as Long

        if (userId == "emented") {
            userId = "0"
        }

        val updateResult = commentService.deleteComment(
            commentId,
            userId.toLong(),
            isModerator,
        )

        delegateExecution.setVariable(
            "delete_result",
            if (updateResult) "Комментарий успешно удален!" else "Не удалось удалить комментарий!"
        )
    }
}