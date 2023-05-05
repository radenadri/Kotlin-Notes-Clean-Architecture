package com.radenadri.notes.feature.note.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.radenadri.notes.feature.note.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}