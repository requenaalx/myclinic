package org.myclinic.model.patient

import org.myclinic.model.Address
import org.myclinic.model.Email
import org.myclinic.model.Phone
import org.myclinic.model.Name

class Guardian(
    name: Name,
    email: Email? = null,
    phone: Phone,
    override val cpf: Cpf,
    address: Address
) : Responsible {
    override var name = name
        private set
    override var email = email
        private set
    override var phone = phone
        private set
    var address = address
        private set

    fun updateName(newName: Name) {
        name = newName
    }

    fun updateEmail(newEmail: Email) {
        email = newEmail
    }

    fun updatePhone(newPhone: Phone) {
        phone = newPhone
    }

    fun updateAddress(newAddress: Address) {
        address = newAddress
    }
}
