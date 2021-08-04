package org.myclinic.model.address

import org.myclinic.model.exception.PatternMismatch

private const val ZIPCODE_PATTERN = "[0-9]{8}"

data class Address(
    val street: String,
    val number: String,
    val complement: String,
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
