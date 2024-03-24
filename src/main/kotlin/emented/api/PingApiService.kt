package emented.api

import emented.model.PingResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PingApiService : PingApiDelegate {
    override fun ping(): ResponseEntity<PingResponse> {
        return ResponseEntity.ok(PingResponse("pong"))
    }
}
