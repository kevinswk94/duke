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

    /**
     * Instantiates a Duke instance with a path to a save file.
     * @param filePath The save file location relative to the project root
     */
    public Duke(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = new TaskList(storage.loadTasks());
        this.ui = new Ui();
    }

    /**
     * The main method of the Duke class.
     * @param args Arguments to be passed into Duke
     */
    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    /**
     * Starts the Duke program after initialisation.
     */
    public void run() {
        Ui.printWelcomeMessage();

        Parser.parse(storage, tasks, ui);
    }

    /**
     * Retrieves a response from stdout and returns it as a String.
     * @param input The input passed to Duke
     * @return A String returned from stdout
     */
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