package Seminar6.notes.core.domain;

import java.util.Date;

public class Note {

    private int userId;
    private int id;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return String.format("[%d] - [%s] - [%s]", id, title, details);
    }

    public Note(int userId, int id, String title, String details, Date creationDate) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.details = details;
        this.creationDate = creationDate;
    }
}
