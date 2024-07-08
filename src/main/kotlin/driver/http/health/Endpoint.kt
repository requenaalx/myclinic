package driver.http.health

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/health")
class Endpoint() {

    @GET
    fun get(): Response {
        return Response.noContent().build()
    }
}
