package application.domain.model.patient

import java.time.LocalDate

data class DeceaseDate(val value: LocalDate) {
    init {
        if (value.isBefore(LocalDate.now()))
            throw Exception("A future date was provided")
    }
}
