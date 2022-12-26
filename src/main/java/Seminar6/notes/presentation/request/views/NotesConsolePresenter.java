package Seminar6.notes.presentation.request.views;

import Seminar6.notes.core.application.interfaces.NotesPresenter;
import Seminar6.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printallNotes(Collection<Note> collection) {
        for (Note note: collection) {
            System.out.println(note);
        }
    }
}
