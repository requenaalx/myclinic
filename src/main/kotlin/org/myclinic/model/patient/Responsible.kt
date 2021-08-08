package org.myclinic.model.patient

import org.myclinic.model.Email
import org.myclinic.model.Phone

interface Responsible {
    val name: String
    val phone: Phone
    val email: Email?
}
