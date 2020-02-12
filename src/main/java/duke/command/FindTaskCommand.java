package duke.command;

import duke.exception.DukeException;
import duke.exception.InsufficientArgumentsException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindTaskCommand extends Command {
    private String searchTerm;

    public FindTaskCommand(String[] cmdArgs) throws DukeException {
        if (!hasValidNumOfArgs(cmdArgs.length)) {
            throw new InsufficientArgumentsException("☹ OOPS!!! FIND command expects a search term!");
        } else {
            this.searchTerm = cmdArgs[1];
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        assert searchTerm != null : "search term should not be null";
        Ui.printMessage(tasks.findTask(searchTerm));
    }

    @Override
    public boolean isByeCommand() {
        return false;
    }
}
