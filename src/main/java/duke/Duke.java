package duke;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke() {
        this("data/duke.txt");
    }

    public Duke(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = new TaskList(storage.loadTasks());
        this.ui = new Ui();
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    public void run() {
        Ui.printWelcomeMessage();

        Parser.parse(storage, tasks, ui);
    }

    public String getResponse(String input) {
        String response;
        // Change stdout for duke
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            Parser.parse(storage, tasks, ui, input);
        } catch (DukeException dukeException) {
            // Display error message
            System.out.print(dukeException.getMessage());
        }
        response = output.toString();
        // Remove all horizontal divider present
        response = response.trim();
        // Reset stdout for duke
        System.setOut(System.out);
        return response;
    }
}