package org.myclinic.model.patient

import org.myclinic.model.address.Address
import org.myclinic.model.contact.Contactable
import org.myclinic.model.contact.Email
import org.myclinic.model.contact.Phone

data class Guardian(
    val name: String,
    override val email: Email,
    override val phone: Phone,
    val address: Address
) : Contactable {

}
