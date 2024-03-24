package emented.api

import emented.extensions.toModel
import emented.extensions.toResponse
import emented.model.BlockCommunityResponse
import emented.model.CategoryResponse
import emented.model.CommunityResponse
import emented.model.CreateCommunityRequest
import emented.model.CreateCommunityResponse
import emented.model.SearchCommunitiesRequest
import emented.service.CommunityService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

@Service
class CommunityApiService(
    private val communityService: CommunityService,
) : CommunityApiDelegate {
    override fun createCommunity(
        createCommunityRequest: CreateCommunityRequest,
    ): ResponseEntity<CreateCommunityResponse> {
        val creationResult = communityService.createCommunity(createCommunityRequest.toModel())
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    override fun blockCommunity(communityId: Long): ResponseEntity<BlockCommunityResponse> {
        return ResponseEntity.ok(BlockCommunityResponse(communityService.blockCommunity(communityId)))
    }
}
