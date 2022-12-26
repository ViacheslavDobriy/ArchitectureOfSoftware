package Seminar6;

import Seminar6.databases.NotesDatabase;
import Seminar6.notes.core.application.ConcreteNoteEditor;
import Seminar6.notes.infrastructure.DatabaseContext;
import Seminar6.notes.presentation.request.controller.NotesController;
import Seminar6.notes.presentation.request.views.NotesConsolePresenter;

/**
 * Приложение "редактор заметок"
 */
public class NotesApplication {
    public static void main(String[] args) {
        NotesController notesController = new NotesController(
                new ConcreteNoteEditor(new DatabaseContext(new NotesDatabase()), new NotesConsolePresenter()));
        notesController.routeGetAll();
    }
}
