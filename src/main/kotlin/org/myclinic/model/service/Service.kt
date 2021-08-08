package org.myclinic.model.service

import org.myclinic.model.patient.Patient
import org.myclinic.model.provider.Provider
import java.time.LocalDateTime

class Service(
    val provider: Provider,
    val patient: Patient,
    var date: LocalDateTime,
    var status: Status = Status.SCHEDULED,
    var history: List<Request> = emptyList()
) {
    fun cancel(cancelRequest: CancelRequest) {
        if (status !== Status.SCHEDULED) {
            throw Exception("Only scheduled services can be rescheduled")
        }

        status = Status.CANCELLED

        history = history.plus(cancelRequest)
    }

    fun reschedule(rescheduleRequest: RescheduleRequest) {
        if (status !== Status.SCHEDULED) {
            throw Exception("Only scheduled services can be rescheduled")
        }

        if (rescheduleRequest.newDate.isBefore(LocalDateTime.now())) {
            throw Exception("The next date must be greater than the current date")
        }

        date = rescheduleRequest.newDate

        history = history.plus(rescheduleRequest)
    }

    fun finish() {
        if (status !== Status.SCHEDULED) {
            throw Exception("Only scheduled services can be finished")
        }

        status = Status.FINISHED
    }
}
