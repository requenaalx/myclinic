package org.myclinic.model.patient

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.PatternMismatch

private const val PATTERN: String = "[0-9]{11}"

data class Cpf(val number: String) {
    init {
        if (number.isEmpty()) throw EmptyArgument(number::class)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
