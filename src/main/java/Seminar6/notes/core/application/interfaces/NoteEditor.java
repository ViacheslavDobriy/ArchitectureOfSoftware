package Seminar6.notes.core.application.interfaces;

import Seminar6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public interface NoteEditor extends Editor<Note, Integer> {
    void printAll();
}
