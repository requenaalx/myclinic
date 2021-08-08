package org.myclinic.model.service

import java.time.LocalDateTime

interface Request {
    val date: LocalDateTime
    val type: RequestType
    val reason: String
}