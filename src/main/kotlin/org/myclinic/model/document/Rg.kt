package org.myclinic.model.document

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.PatternMismatch

private const val PATTERN: String = "[0-9]{9}"

data class Rg(override val number: String) : Document {
    override val type: DocumentType = DocumentType.RG

    init {
        if (number.isEmpty()) throw EmptyArgument(number::class.simpleName!!)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
