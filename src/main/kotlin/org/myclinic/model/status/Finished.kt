package org.myclinic.model.status

data class Finished(
    val patientAttended: Boolean = true, val reason: String?
) : Status {
    override val type: HealthServiceStatus = HealthServiceStatus.FINISHED
}
