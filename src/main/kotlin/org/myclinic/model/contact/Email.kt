package org.myclinic.model.contact

import org.myclinic.model.exception.EmptyArgument

data class Email(val address: String) {
    init {
        if (address.isEmpty()) throw EmptyArgument(address::class.simpleName!!)
    }
}
