package com.radenadri.notes.di

import android.app.Application
import androidx.room.Room
import com.radenadri.notes.feature.note.data.datasource.NoteDatabase
import com.radenadri.notes.feature.note.data.repository.NoteRepositoryImpl
import com.radenadri.notes.feature.note.domain.repository.NoteRepository
import com.radenadri.notes.feature.note.domain.usecase.AddNote
import com.radenadri.notes.feature.note.domain.usecase.DeleteNote
import com.radenadri.notes.feature.note.domain.usecase.GetNote
import com.radenadri.notes.feature.note.domain.usecase.GetNotes
import com.radenadri.notes.feature.note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}