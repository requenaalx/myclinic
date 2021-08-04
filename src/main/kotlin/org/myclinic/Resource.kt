package org.myclinic

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/greeting")
class Resource {

    @GET
    fun hello() = Greeting("hello")
}