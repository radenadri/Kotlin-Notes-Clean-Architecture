package com.radenadri.notes.feature.note.domain.usecase

import com.radenadri.notes.feature.note.domain.model.Note
import com.radenadri.notes.feature.note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.deleteNote(note)
}