package emented.api

import emented.extensions.toModel
import emented.extensions.toResponse
import emented.model.AddModerationRequest
import emented.model.AddModerationResponse
import emented.model.BlockCommunityResponse
import emented.model.CategoryResponse
import emented.model.CommunityRequest
import emented.model.CommunityResponse
import emented.model.CreateCommunityResponse
import emented.model.SearchCommunitiesRequest
import emented.model.UnarchiveCommunityResponse
import emented.service.CommunityService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CommunityApiService(
    private val communityService: CommunityService,
) : CommunityApiDelegate {
    override fun createCommunity(
        communityRequest: CommunityRequest,
    ): ResponseEntity<CreateCommunityResponse> {
        val creationResult = communityService.createCommunity(communityRequest.toModel())
            ?: return ResponseEntity.badRequest().build()

        return ResponseEntity.ok(CreateCommunityResponse(creationResult.id!!))
    }

    override fun getCategories(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok(communityService.getCategories().map { it.toResponse() })
    }

    override fun getCommunity(communityId: Long): ResponseEntity<CommunityResponse> {
        val community = communityService.getCommunityById(communityId) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(community.toResponse())
    }

    override fun searchCommunities(
        searchCommunitiesRequest: SearchCommunitiesRequest,
    ): ResponseEntity<List<CommunityResponse>> {
        return ResponseEntity.ok(
            communityService.searchCommunities(
                searchCommunitiesRequest.name,
                searchCommunitiesRequest.category,
                searchCommunitiesRequest.language?.toModel(),
                searchCommunitiesRequest.isForChildren,
            ).map { it.toResponse() },
        )
    }

    override fun blockCommunity(communityId: Long): ResponseEntity<BlockCommunityResponse> {
        return ResponseEntity.ok(BlockCommunityResponse(communityService.blockCommunity(communityId)))
    }

    override fun unarchiveCommunity(communityId: Long): ResponseEntity<UnarchiveCommunityResponse> {
        return ResponseEntity.ok(UnarchiveCommunityResponse(communityService.unarchiveCommunity(communityId)))
    }

    override fun addModerationInfo(
        communityId: Long,
        addModerationRequest: AddModerationRequest
    ): ResponseEntity<AddModerationResponse> {
        return ResponseEntity.ok(
            AddModerationResponse(communityService.addModeration(communityId, addModerationRequest.toModel()))
        )
    }

    override fun increaseCommunityInterestRate(communityId: Long, rate: Long): ResponseEntity<Unit> {
        communityService.increaseCommunityInterestRate(communityId, rate)

        return ResponseEntity.ok().build()
    }
}
