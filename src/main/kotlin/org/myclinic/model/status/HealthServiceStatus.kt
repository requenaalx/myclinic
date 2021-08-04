package org.myclinic.model.status

enum class HealthServiceStatus(override val type: HealthServiceStatus) :
    Status {
    SCHEDULED(SCHEDULED),
    FINISHED(FINISHED),
    RESCHEDULED(RESCHEDULED),
    CANCELLED(CANCELLED);
}
