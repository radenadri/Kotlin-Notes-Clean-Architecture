package com.radenadri.notes.feature.note.domain.model

import com.radenadri.notes.feature.note.domain.util.NoteOrder
import com.radenadri.notes.feature.note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)