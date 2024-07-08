package application.domain.model.patient

data class Guardians(val collection: Set<Guardian> = emptySet()) {
    val hasSingleElement
        get() = collection.count() == 1

    fun find(guardianCpf: Cpf): Guardian =
        collection.find { it.cpf == guardianCpf }
            ?: throw GuardianNotFound(guardianCpf)

    fun plus(guardian: Guardian): Guardians =
        Guardians(collection.plus(guardian))

    fun minus(guardian: Guardian): Guardians =
        Guardians(collection.minus(guardian))
}
