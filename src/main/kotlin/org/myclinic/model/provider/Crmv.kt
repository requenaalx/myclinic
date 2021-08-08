package org.myclinic.model.provider

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.PatternMismatch

private const val PATTERN: String = ""

data class Crmv(override val number: String) : License {
    init {
        if (number.isEmpty()) throw EmptyArgument(number::class.simpleName!!)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
