package application.domain.model.patient

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class BirthDate(val value: LocalDate) {
    init {
        if (value.isAfter(LocalDate.now()))
            throw Exception("A future date was provided")
    }

    fun calculateAge(): Long =
        value.until(LocalDate.now(), ChronoUnit.YEARS)
}
