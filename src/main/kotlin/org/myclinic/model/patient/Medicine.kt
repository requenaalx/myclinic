package org.myclinic.model.patient

import org.myclinic.model.exception.EmptyArgument

data class Medicine(val value: String) {
    init {
        if (value.isEmpty()) throw EmptyArgument(value::class)
    }
}
