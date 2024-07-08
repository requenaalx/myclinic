package application.domain.model.provider

import application.domain.model.Email
import application.domain.model.Phone

class Therapist(
    override val license: Crp,
    val name: String,
    val phone: Phone,
    val email: Email
) : Provider