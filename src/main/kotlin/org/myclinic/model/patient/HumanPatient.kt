package org.myclinic.model.patient

import org.myclinic.model.Address
import org.myclinic.model.Email
import org.myclinic.model.Phone
import org.myclinic.model.exception.EmptyArgument
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class HumanPatient(
    name: String,
    email: Email?,
    address: Address,
    schooling: Schooling,
    religion: String,
    job: String,
    val rg: Rg,
    val cpf: Cpf,
    val birthDate: LocalDate,
    phoneNumbers: Set<Phone>,
    medicines: Set<String> = emptySet(),
    status: Status = Status.ACTIVE,
    guardians: Set<Guardian> = emptySet(),
    history: Set<Note> = emptySet(),
) : Patient {
    var name = name
        private set
    var email = email
        private set
    var address = address
        private set
    var phoneNumbers = phoneNumbers
        private set
    var schooling = schooling
        private set
    var religion = religion
        private set
    var medicines = medicines
        private set
    var job = job
        private set
    var status = status
        private set
    var guardians = guardians
        private set
    var history = history
        private set
    val isUnderage: Boolean
        get() = birthDate.until(LocalDate.now(), ChronoUnit.YEARS) < 18

    init {
        if (phoneNumbers.isEmpty()) {
            throw EmptyArgument(phoneNumbers::class.simpleName!!)
        }

        if (isUnderage && guardians.isEmpty()) {
            throw EmptyArgument(guardians::class.simpleName!!)
        }
    }

    fun updateName(newName: String) {
        name = newName
    }

    fun updateEmail(newEmail: Email) {
        email = newEmail
    }

    fun updateAddress(newAddress: Address) {
        address = newAddress
    }

    fun updateSchooling(updatedSchooling: Schooling) {
        schooling = updatedSchooling
    }

    fun updateReligion(newReligion: String) {
        religion = newReligion
    }

    fun updateJob(newJob: String) {
        job = newJob
    }

    fun updateMedicines(updatedMedicines: Set<String>) {
        medicines = updatedMedicines
    }

    fun updatePhoneNumbers(updatedPhoneNumbers: Set<Phone>) {
        if (updatedPhoneNumbers.isEmpty()) {
            throw EmptyArgument(updatedPhoneNumbers::class.simpleName!!)
        }

        phoneNumbers = updatedPhoneNumbers
    }

    fun updateGuardians(updatedGuardians: Set<Guardian>) {
        if (isUnderage && updatedGuardians.isEmpty()) {
            throw EmptyArgument(updatedGuardians::class.simpleName!!)
        }

        guardians = updatedGuardians
    }

    fun makeNote(note: Note) {
        history = history.plus(note)
    }

    fun deactivate(reason: String) {
        status = Status.ABANDONED
    }

    fun discharge() {
        status = Status.DISCHARGED
    }
}