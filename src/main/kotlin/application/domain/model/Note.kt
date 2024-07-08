package application.domain.model

import java.time.LocalDate

// Mutable VO?
class Note(content: String, val date: LocalDate = LocalDate.now()) {
    var content = content
        private set

    fun updateContent(updatedContent: String) {
        content = updatedContent
    }
}
