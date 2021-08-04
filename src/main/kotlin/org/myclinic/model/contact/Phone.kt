package org.myclinic.model.contact

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.PatternMismatch

private const val CODE_PATTERN: String = "[0-9]{2}"
private const val NUMBER_PATTERN: String = "[0-9]{9}"

data class Phone(val code: String, val number: String) {
    init {
        if (code.isEmpty()) throw EmptyArgument(code::class.simpleName!!)
        if (!code.matches(CODE_PATTERN.toRegex())) throw PatternMismatch()

        if (number.isEmpty()) throw EmptyArgument(number::class.simpleName!!)
        if (!number.matches(NUMBER_PATTERN.toRegex())) throw PatternMismatch()
    }
}
