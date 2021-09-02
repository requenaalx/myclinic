package org.myclinic.model.provider

import org.myclinic.model.Email
import org.myclinic.model.Phone

class Therapist(
    override val license: Crp,
    val name: String,
    val phone: Phone,
    val email: Email
) : Provider