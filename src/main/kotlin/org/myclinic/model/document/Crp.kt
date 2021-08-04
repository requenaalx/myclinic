package org.myclinic.model.document

import org.myclinic.model.exception.EmptyArgument
import org.myclinic.model.exception.PatternMismatch

private const val PATTERN: String = "[0-9]{2}/[0-9]{5}"

data class Crp(override val number: String) : Document {
    override val type: DocumentType = DocumentType.CRP

    init {
        if (number.isEmpty()) throw EmptyArgument(number::class.simpleName!!)
        if (!number.matches(PATTERN.toRegex())) throw PatternMismatch()
    }
}
