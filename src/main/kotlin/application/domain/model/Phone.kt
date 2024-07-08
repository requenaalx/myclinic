package application.domain.model

import application.domain.exception.EmptyArgument
import application.domain.exception.PatternMismatch

private const val CODE_PATTERN: String = "[0-9]{2}"
private const val NUMBER_PATTERN: String = "[0-9]{9}"

data class Phone(val code: String, val number: String) {
    init {
        if (code.isEmpty()) throw EmptyArgument(code::class)
        if (!code.matches(CODE_PATTERN.toRegex())) throw PatternMismatch()

        if (number.isEmpty()) throw EmptyArgument(number::class)
        if (!number.matches(NUMBER_PATTERN.toRegex())) throw PatternMismatch()
    }
}
