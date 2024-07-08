package application.domain.model.provider

import application.domain.exception.EmptyArgument
import application.domain.exception.PatternMismatch

private const val PATTERN: String = "[0-9]{2}/[0-9]{5}"

data class Crp(override val number: String) : License {
    init {
        if (number.isEmpty()) throw EmptyArgument(number::class)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
