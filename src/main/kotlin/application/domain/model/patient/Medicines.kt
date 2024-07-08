package application.domain.model.patient

data class Medicines(val collection: Set<Medicine> = emptySet()) {
    fun plus(medicine: Medicine): Medicines =
        Medicines(collection.plus(medicine))

    fun minus(medicine: Medicine): Medicines =
        Medicines(collection.minus(medicine))
}
