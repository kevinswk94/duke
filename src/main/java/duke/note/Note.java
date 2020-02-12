package duke.note;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private String noteText;
    private LocalDateTime timestamp;

    /*public String generateSaveFileEntry() {

    }*/

    @Override
    public String toString() {
        return String.format("[N] %s: $s", timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), noteText);
    }
}
