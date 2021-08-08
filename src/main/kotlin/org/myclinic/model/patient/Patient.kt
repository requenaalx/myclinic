package org.myclinic.model.patient

interface Patient {
    val name: String
    val history: List<Note>
    val responsibles: Set<Responsible>
}
