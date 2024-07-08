package application.domain.model.patient

import application.domain.model.Address
import application.domain.model.Email
import application.domain.model.Name
import application.domain.model.Phone
import application.domain.exception.EmptyArgument
import application.domain.exception.EmptyingNotAllowed

private const val LEGAL_AGE = 18

class Human(
    name: Name,
    email: Email? = null,
    address: Address,
    schooling: Schooling,
    religion: Religion,
    occupation: Occupation,
    val rg: Rg,
    val cpf: Cpf,
    val birthDate: BirthDate,
    phone: Phone,
    emergencyContacts: EmergencyContacts,
    medicines: Medicines = Medicines(),
    status: Status = Status.ACTIVE,
    guardians: Guardians = Guardians(),
    deceaseDate: DeceaseDate? = null
) : Patient {
    var name = name
        private set
    var email = email
        private set
    var address = address
        private set
    var deceaseDate = deceaseDate
        private set
    var phone = phone
        private set
    var emergencyContacts = emergencyContacts
        private set
    var schooling = schooling
        private set
    var religion = religion
        private set
    var medicines = medicines
        private set
    var occupation = occupation
        private set
    var status = status
        private set
    var guardians = guardians
        private set
    val isOfLegalAge: Boolean
        get() = birthDate.calculateAge() >= LEGAL_AGE

    init {
        if (!isOfLegalAge && guardians.collection.isEmpty()) {
            throw EmptyArgument(guardians::class)
        }
    }

    fun updateName(newName: Name) {
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

    fun updateReligion(newReligion: Religion) {
        religion = newReligion
    }

    fun updateOccupation(newOccupation: Occupation) {
        occupation = newOccupation
    }

    fun addMedicine(medicineName: Medicine) {
        medicines = medicines.plus(medicineName)
    }

    fun removeMedicine(medicineName: Medicine) {
        medicines = medicines.minus(medicineName)
    }

    fun updatePhone(newPhone: Phone) {
        phone = newPhone
    }

    fun addEmergencyContact(emergencyContact: EmergencyContact) {
        emergencyContacts = emergencyContacts.plus(emergencyContact)
    }

    fun removeEmergencyContact(emergencyContact: EmergencyContact) {
        emergencyContacts = emergencyContacts.minus(emergencyContact)
    }

    fun addGuardian(guardian: Guardian) {
        guardians = guardians.plus(guardian)
    }

    fun removeGuardian(guardianCpf: Cpf) {
        if (!isOfLegalAge && guardians.hasSingleElement) {
            throw EmptyingNotAllowed(guardians::class)
        }

        guardians = guardians.minus(guardians.find(guardianCpf))
    }

    fun updateGuardianName(guardianCpf: Cpf, newName: Name) =
        guardians.find(guardianCpf).updateName(newName)

    fun updateGuardianPhone(guardianCpf: Cpf, newPhone: Phone) =
        guardians.find(guardianCpf).updatePhone(newPhone)

    fun updateGuardianEmail(guardianCpf: Cpf, newEmail: Email) =
        guardians.find(guardianCpf).updateEmail(newEmail)

    fun updateGuardianAddress(guardianCpf: Cpf, newAddress: Address) =
        guardians.find(guardianCpf).updateAddress(newAddress)

    fun discharge() {
        status = Status.DISCHARGED
    }

    fun deactivate() {
        status = Status.INACTIVE
    }

    fun deactivateByDecease(dateOfDecease: DeceaseDate) {
        deceaseDate = dateOfDecease
        status = Status.DECEASED
    }
}