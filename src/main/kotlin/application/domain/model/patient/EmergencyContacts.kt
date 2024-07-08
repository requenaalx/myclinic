package application.domain.model.patient

import application.domain.exception.EmptyArgument
import application.domain.exception.EmptyingNotAllowed

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
