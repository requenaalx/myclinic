package org.myclinic.model.patient

import org.myclinic.model.Email
import org.myclinic.model.Name
import org.myclinic.model.Phone

interface Responsible {
    val name: Name
    val phone: Phone
    val email: Email?
    val cpf: Cpf
}
