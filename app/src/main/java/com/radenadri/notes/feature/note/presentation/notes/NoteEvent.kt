package com.radenadri.notes.feature.note.presentation.notes

import com.radenadri.notes.feature.note.domain.model.Note
import com.radenadri.notes.feature.note.domain.util.NoteOrder

sealed class NoteEvent {
    data class Order(val noteOrder: NoteOrder): NoteEvent()
    data class DeleteNote(val note: Note): NoteEvent()
    object RestoreNote: NoteEvent()
    object ToggleOrderSection: NoteEvent()
}
