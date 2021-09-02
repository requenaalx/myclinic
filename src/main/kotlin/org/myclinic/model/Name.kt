package org.myclinic.model

import org.myclinic.model.exception.EmptyArgument

data class Name(val value: String) {
    init {
        if (value.isEmpty()) throw EmptyArgument(value::class)
    }
}
