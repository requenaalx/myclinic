package org.myclinic.model.service

import org.myclinic.model.exception.EmptyArgument
import java.time.LocalDateTime

data class RescheduleRequest(
    override val date: LocalDateTime = LocalDateTime.now(),
    override val reason: String,
    val newDate: LocalDateTime
) : Request {
    override val type: RequestType = RequestType.RESCHEDULE

    init {
        if (reason.isEmpty()) {
            throw EmptyArgument(reason::class.simpleName!!)
        }
    }
}
