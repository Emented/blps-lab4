package emented.delegate.community

import emented.model.Language
import emented.model.domain.Community
import emented.service.CommunityService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class GetCommunitiesRequestProcessor(
    private val communityService: CommunityService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        val name = delegateExecution.getVariable("name_filter")?.toString()
        val language = delegateExecution.getVariable("language_filter")?.let { Language.valueOf(it.toString()) }
        val isForChildren = emptyToNull(
            delegateExecution.getVariable("is_for_children_filter").toString()
        )?.toBooleanStrictOrNull()
        val category = delegateExecution.getVariable("category_filter")?.toString()

        val result = communityService.searchCommunities(
            emptyToNull(name),
            emptyToNull(category),
            language,
            isForChildren
        )

        delegateExecution.setVariable(
            "community_count_result",
            result.size
        )

        delegateExecution.setVariable(
            "communities_result",
            if (result.isEmpty()) "Комьюнити не найдены" else getPrettyCommunityString(result)
        )
    }

    private fun emptyToNull(name: String?): String? {
        if (name.isNullOrBlank()) {
            return null
        }

        return name
    }

    private fun getPrettyCommunityString(communities: List<Community>): String {
        return communities.joinToString(
            separator = "〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\n"
        )
    }
}