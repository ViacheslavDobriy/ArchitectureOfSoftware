package Seminar6.notes.presentation.request.controller;

import Seminar6.notes.core.application.interfaces.NoteEditor;
import Seminar6.notes.core.domain.Note;

public class NotesController extends Controller {

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor noteEditor) {
        this.notesEditor = noteEditor;
    }

    public void routeAddNote(Note note){
        this.notesEditor.add(note);
    }

    public void routeRemoveNote(Note note){
        this.notesEditor.remove(note);
    }

    public void routeGetAll() {
        this.notesEditor.printAll();
    }
}
