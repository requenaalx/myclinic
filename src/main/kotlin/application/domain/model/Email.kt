package application.domain.model

import application.domain.exception.EmptyArgument

data class Email(val address: String) {
    init {
        if (address.isEmpty()) throw EmptyArgument(address::class)
    }
}
