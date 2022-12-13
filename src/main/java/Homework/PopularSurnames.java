package Homework;

public enum PopularSurnames {
    DOBROV("Dobrov"),
    IVANOV("Ivanov"),
    NIKOLAEV("Nikolaev"),
    SEMENOV("Semenov");
    private String surname;
    PopularSurnames(String name) {
        this.surname = name;
    }

    public String getSurname() {
        return surname;
    }
}
