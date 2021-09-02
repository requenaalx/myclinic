package org.myclinic.model.patient

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.EmptyingNotAllowed

data class EmergencyContacts(val collection: Set<EmergencyContact>) {
    init {
        if (collection.isEmpty()) throw EmptyArgument(this::class)
    }

    private val hasSingleElement
        get() = collection.count() == 1

    fun plus(emergencyContact: EmergencyContact): EmergencyContacts =
        EmergencyContacts(collection.plus(emergencyContact))

    fun minus(emergencyContact: EmergencyContact): EmergencyContacts =
        if (hasSingleElement) throw EmptyingNotAllowed(this::class)
        else EmergencyContacts(collection.minus(emergencyContact))
}
