package driver

import application.domain.model.*
import application.domain.model.patient.*
import java.time.LocalDate
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/patients")
class Patient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    fun findByCpf(@PathParam("cpf") cpf: String): Human {
        return Human(
            name = Name("Dwight Schrute"),
            email = Email("schrute.d@dundermifflin.com"),
            address = Address(
                street = "Slough Avenue",
                number = "1725",
                city = "Scranton",
                state = State.PARANA,
                zipCode = "18501"
            ),
            schooling = Schooling.HIGH_SCHOOL,
            religion = Religion("DO_NOT_KNOW"),
            occupation = Occupation("Assistant Regional Manager"),
            rg = Rg("473863522"),
            cpf = Cpf("57779560252"),
            birthDate = BirthDate(LocalDate.of(1970, 1, 20)),
            phone = Phone("01", "987654321"),
            emergencyContacts = EmergencyContacts(
                setOf(
                    EmergencyContact(
                        Name("Michael Scott"),
                        Phone("02", "123456789")
                    )
                )
            )
        )
    }
}