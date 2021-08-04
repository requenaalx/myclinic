package org.myclinic.model.status

import java.time.LocalDateTime

data class Rescheduled(
    val reason: String,
    val date: LocalDateTime = LocalDateTime.now()
) : Status {
    override val type: HealthServiceStatus = HealthServiceStatus.RESCHEDULED
}
