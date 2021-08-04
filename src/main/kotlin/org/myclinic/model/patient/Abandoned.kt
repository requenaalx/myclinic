package org.myclinic.model.patient

import java.time.LocalDateTime

data class Abandoned(
    val reason: String,
    val date: LocalDateTime = LocalDateTime.now()
) :
    Status {
    override val type: PatientStatus = PatientStatus.ABANDONED
}