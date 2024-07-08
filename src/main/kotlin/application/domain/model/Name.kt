package application.domain.model

import application.domain.exception.EmptyArgument

data class Name(val value: String) {
    init {
        if (value.isEmpty()) throw EmptyArgument(value::class)
    }
}
