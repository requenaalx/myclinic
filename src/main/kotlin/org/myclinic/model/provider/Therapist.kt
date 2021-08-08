package org.myclinic.model.provider

import org.myclinic.model.Email
import org.myclinic.model.Phone

class Therapist(
    private val crp: Crp,
    val name: String,
    val phone: Phone,
    val email: Email
) : Provider {
    override fun getLicense(): License = crp
}
