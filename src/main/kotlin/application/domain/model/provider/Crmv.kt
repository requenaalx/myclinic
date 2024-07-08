package application.domain.model.provider

import application.domain.exception.EmptyArgument
import application.domain.exception.PatternMismatch

private const val PATTERN: String = ""

data class Crmv(override val number: String) : License {
    init {
        if (number.isEmpty()) throw EmptyArgument(number::class)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
