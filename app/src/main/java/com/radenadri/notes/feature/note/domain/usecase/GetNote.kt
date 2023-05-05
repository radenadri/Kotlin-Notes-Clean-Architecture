package com.radenadri.notes.feature.note.domain.usecase

import com.radenadri.notes.feature.note.domain.model.Note
import com.radenadri.notes.feature.note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int) : Note? = repository.getNoteById(id)
}