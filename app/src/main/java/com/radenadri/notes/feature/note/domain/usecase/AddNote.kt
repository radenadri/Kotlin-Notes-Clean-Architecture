package com.radenadri.notes.feature.note.domain.usecase

import com.radenadri.notes.feature.note.domain.model.InvalidNoteException
import com.radenadri.notes.feature.note.domain.model.Note
import com.radenadri.notes.feature.note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        // Check if the title is empty
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }

        // Check if the content is empty
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }
}