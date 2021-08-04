package org.myclinic.model.patient

import org.myclinic.model.contact.Contactable

interface Patient {
    val name: String
    val contactable: Contactable
    val history: List<Note>
}
