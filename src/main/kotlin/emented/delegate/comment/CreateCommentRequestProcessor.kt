package emented.delegate.comment

import emented.service.CommentService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class CreateCommentRequestProcessor(
    private val runtimeService: RuntimeService,
    private val commentService: CommentService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        var userId = delegateExecution.processEngineServices.identityService.currentAuthentication.userId
        if (userId == "guest") {
            runtimeService.deleteProcessInstance(delegateExecution.processInstanceId, "Guest cannot add comments!")
            return
        }

        val communityId = delegateExecution.getVariable("community_id_create") as Long
        val commentText = delegateExecution.getVariable("comment_text_create").toString()

        if (userId == "emented") {
            userId = "0"
        }

        val createdComment = commentService.createComment(
            communityId,
            userId.toLong(),
            commentText,
        )

        if (createdComment == null) {
            delegateExecution.setVariable(
                "create_result",
                "Ошибка при создании комментария!"
            )
            return
        }

        delegateExecution.setVariable(
            "create_result",
            "Коментарий успешно создан! Его id: ${createdComment.id}"
        )
    }
}