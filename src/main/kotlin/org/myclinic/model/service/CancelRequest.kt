package org.myclinic.model.service

import org.myclinic.model.exception.EmptyArgument
import java.time.LocalDateTime

data class CancelRequest(
    override val date: LocalDateTime = LocalDateTime.now(),
    override val reason: String
) : Request {
    override val type: RequestType = RequestType.CANCEL

    init {
        if (reason.isEmpty()) {
            throw EmptyArgument(reason::class.simpleName!!)
        }
    }
}
