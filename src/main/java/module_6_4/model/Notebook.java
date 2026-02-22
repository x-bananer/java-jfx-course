package module_6_4.model;

import java.util.ArrayList;

public class Notebook {
    private final ArrayList<Note> notes = new ArrayList<>();

    public void add(Note note) {
        notes.add(note);
    }

    public ArrayList<Note> getAll() {
        return notes;
    }
}
