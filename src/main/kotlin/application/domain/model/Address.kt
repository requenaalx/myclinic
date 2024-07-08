package application.domain.model

import application.domain.exception.PatternMismatch

private const val ZIPCODE_PATTERN = "[0-9]{8}"

data class Address(
    val street: String,
    val number: String,
    val complement: String? = null,
    val city: String,
    val state: State,
    val zipCode: String
) {
    init {
        if (!zipCode.matches(ZIPCODE_PATTERN.toRegex())) {
            throw PatternMismatch()
        }
    }
}
