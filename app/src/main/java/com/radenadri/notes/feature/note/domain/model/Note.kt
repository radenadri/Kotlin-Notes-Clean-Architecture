package com.radenadri.notes.feature.note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.radenadri.notes.ui.theme.BabyBlue
import com.radenadri.notes.ui.theme.LightGreen
import com.radenadri.notes.ui.theme.RedOrange
import com.radenadri.notes.ui.theme.RedPink
import com.radenadri.notes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)
