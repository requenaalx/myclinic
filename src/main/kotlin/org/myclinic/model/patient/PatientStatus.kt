package org.myclinic.model.patient

enum class PatientStatus(override val type: PatientStatus) : Status {
    ACTIVE(ACTIVE), ABANDONED(ABANDONED), DISCHARGED(DISCHARGED)
}
