package application.domain.model.patient

class GuardianNotFound(guardianCpf: Cpf) :
    Exception("Any guardian was found with CPF ${guardianCpf.number}")
