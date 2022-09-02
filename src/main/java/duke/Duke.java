package duke;

import duke.command.Command;

public class Duke {
    public Ui ui;
    public TaskList taskList;
    public Storage storage;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList(storage.loadTaskList());
    }

    public enum Keyword {
        EXIT("bye"), LIST("list"), TODO("todo"), DEADLINE("deadline"), EVENT("event"), DELETE("delete"), MARK("mark"),
        UNMARK("unmark"), FIND("find");

        private String keyword;

        private Keyword(String keyword) {
            this.keyword = keyword;
        }

        public String getKeyword() {
            return this.keyword;
        }
    }


    /**
     * Starts the Duke program and requests for user input.
     * If user types "bye", the program ends.
     */
    /*
    public void run() {
        ui.printGreetingMessage();
        taskList = new TaskList(storage.loadTaskList());
        String userInput;

        while(true) {
            userInput = ui.getUserInput();
            try {
                Command command = Parser.parse(userInput);
                command.execute(taskList, storage, ui);
                if (command.isExit()) {
                    break;
                }
            } catch (DukeException exception) {
                ui.printMessage(exception.toString() + "\n");
            }
        }
    }
     */

    public String getResponse(String userInput) {
        try {
            Command command = Parser.parse(userInput);
            return command.execute(taskList, storage, ui);
        } catch (DukeException exception) {
            return exception.toString();
        }
    }

    /**
     * Calls the run() function.
     * Serves as an entry point of the Duke program.
     *
     * @param args The command line arguments.
     */
    /*
    public static void main(String[] args) {
        Duke duke = new Duke("data/duke.txt");
        duke.run();
    }
     */
}
