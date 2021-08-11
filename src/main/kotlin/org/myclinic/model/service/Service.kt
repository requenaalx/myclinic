package org.myclinic.model.service

import org.myclinic.model.patient.Patient
import org.myclinic.model.provider.Provider
import org.myclinic.model.service.exception.ActionNotAllowed
import java.time.LocalDateTime

class Service(
    val provider: Provider,
    val patient: Patient,
    var date: LocalDateTime,
    var status: Status = Status.SCHEDULED,
) {
    fun cancel() {
        if (status !== Status.SCHEDULED) throw ActionNotAllowed(status)

        status = Status.CANCELLED
    }

    fun reschedule(newDate: LocalDateTime) {
        if (status !== Status.SCHEDULED) throw ActionNotAllowed(status)

        if (newDate.isBefore(LocalDateTime.now())) {
            throw Exception("The next date must be a future date")
        }

        date = newDate
    }

    fun finish() {
        if (status !== Status.SCHEDULED) throw ActionNotAllowed(status)

        status = Status.FINISHED
    }
}
