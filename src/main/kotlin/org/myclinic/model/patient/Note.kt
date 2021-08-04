package org.myclinic.model.patient

import java.util.Date

data class Note(val content: String, val date: Date = Date())
