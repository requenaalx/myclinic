package org.myclinic.model.patient

import org.myclinic.model.Address
import org.myclinic.model.Email
import org.myclinic.model.Phone

data class Guardian(
    override val name: String,
    override val email: Email?,
    override val phone: Phone,
    val address: Address
) : Responsible
