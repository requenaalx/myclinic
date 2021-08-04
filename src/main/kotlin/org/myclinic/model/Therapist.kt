package org.myclinic.model

import org.myclinic.model.contact.Email
import org.myclinic.model.contact.Phone
import org.myclinic.model.document.Crp

class Therapist(
    val crp: Crp,
    override val name: String,
    override val phone: Phone,
    override val email: Email
): Provider {


}
