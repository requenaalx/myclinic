package org.myclinic.model.patient

import java.time.LocalDateTime

data class Discharged(val date: LocalDateTime = LocalDateTime.now()) : Status {
    override val type: PatientStatus = PatientStatus.DISCHARGED
}