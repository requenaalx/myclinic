package org.myclinic.driver

import org.myclinic.model.*
import org.myclinic.model.patient.*
import java.time.LocalDate
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/patients")
class Patient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    fun findByCpf(@PathParam("cpf") cpf: String): Human {
        return Human(
            Name("Alexandre Requena"),
            Email("alexandre.requena.95@gmail.com"),
            Address(
                "Avenida Pioneiro Antonio Ruiz Saldanha",
                "1763",
                "Apto. 1407",
                "Maringá",
                State.PARANA,
                "87065303"
            ),
            Schooling.HIGH_SCHOOL,
            Religion("DO_NOT_KNOW"),
            Occupation("Software Engineer"),
            Rg("123246764"),
            Cpf("09941384908"),
            BirthDate(LocalDate.of(1995, 8, 26)),
            Phone("44", "998731154"),
            EmergencyContacts(
                setOf(
                    EmergencyContact(
                        Name("Alexandre"),
                        Phone("44", "998731154")
                    )
                )
            )
        )
    }
}