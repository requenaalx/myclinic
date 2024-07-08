package application.domain.model.patient

import application.domain.exception.EmptyArgument

data class Religion(val value: String) {
    init {
        if (value.isEmpty()) throw EmptyArgument(value::class)
    }
}
