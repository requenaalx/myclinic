package org.myclinic.model

import org.myclinic.model.patient.Patient
import org.myclinic.model.status.*
import java.util.Date

class HealthService(
    val provider: Provider,
    val patient: Patient,
    val date: Date,
    var status: Status = HealthServiceStatus.SCHEDULED
) {
    fun cancel(reason: String) {
        if (this.date < Date()) {
            throw Exception("An older schedule can not be cancelled")
        }

        if (this.status !== HealthServiceStatus.SCHEDULED) {
            throw Exception("Only scheduled services can be cancelled")
        }

        this.status = Cancelled(reason)
    }

    fun reschedule(reason: String, newDate: Date): HealthService {
        if (this.date < Date()) {
            throw Exception("An older schedule can not be rescheduled")
        }

        if (newDate < Date()) {
            throw Exception("The next date must be greater than current date")
        }

        if (this.status !== HealthServiceStatus.SCHEDULED) {
            throw Exception("Only scheduled services can be rescheduled")
        }

        this.status = Rescheduled(reason)

        return HealthService(this.provider, this.patient, newDate)
    }

    fun finish(patientAttended: Boolean = true, reason: String?) {
        if (this.status !== HealthServiceStatus.SCHEDULED) {
            throw Exception("Only scheduled services can be finished")
        }

        this.status = Finished(patientAttended, reason)
    }
}
