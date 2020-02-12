package duke.note;

import duke.exception.OutOfRangeException;
import duke.ui.Ui;

import java.util.ArrayList;
import java.util.List;

public class NoteList {
    private List<Note> notes;

    public NoteList() {
        this.notes = new ArrayList<Note>();
    }

    public NoteList(List<Note> notes) {
        this.notes = notes;
    }

    public int getNumberOfNotes() {
        return this.notes.size();
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void deleteNote(int index) throws OutOfRangeException {
        this.notes.remove(index);
    }

    public void displayNotes() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            if (i != notes.size() - 1) {
                result.append(String.format("%d. %s\n\t", i + 1, notes.get(i)));
            } else {
                result.append(String.format("%d. %s", i + 1, notes.get(i)));
            }
        }
        Ui.printMessage(result.toString());
    }
}
