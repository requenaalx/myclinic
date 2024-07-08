package application.domain.model.patient

import application.domain.exception.EmptyArgument
import application.domain.exception.PatternMismatch

private const val PATTERN: String = "[0-9]{11}"

data class Cpf(val number: String) {
    init {
        if (number.isEmpty()) throw EmptyArgument(number::class)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
