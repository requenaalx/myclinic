package application.domain.model.patient

import application.domain.model.Email
import application.domain.model.Name
import application.domain.model.Phone

interface Responsible {
    val name: Name
    val phone: Phone
    val email: Email?
    val cpf: Cpf
}
