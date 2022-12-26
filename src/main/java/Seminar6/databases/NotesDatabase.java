package Seminar6.databases;

import Seminar6.notes.infrastructure.Database;

public class NotesDatabase implements Database {

    private NotesTable notesTable = new NotesTable();

    public NotesTable getNotesTable(){
        return notesTable;
    }
}
