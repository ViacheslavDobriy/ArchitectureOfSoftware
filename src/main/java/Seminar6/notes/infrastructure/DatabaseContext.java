package Seminar6.notes.infrastructure;

import Seminar6.databases.NotesDatabase;
import Seminar6.databases.NotesRecord;
import Seminar6.notes.core.application.interfaces.NotesDatabaseContext;
import Seminar6.notes.core.domain.Note;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {

    public DatabaseContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public Collection<Note> getAll() {
        Collection<Note> noteList = new ArrayList<>();
        // TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecord()) {
            noteList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return noteList;
    }
}
