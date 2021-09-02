package org.myclinic.model

import org.myclinic.model.exception.EmptyArgument

data class Email(val address: String) {
    init {
        if (address.isEmpty()) throw EmptyArgument(address::class)
    }
}
