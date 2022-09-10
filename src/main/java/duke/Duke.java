package duke;

import duke.command.Command;

public class Duke {
    private TaskList taskList;
    private Storage storage;

    public Duke(String filePath) throws DukeException{
        assert !filePath.isEmpty() : "Filepath should not be empty";
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

    public String getResponse(String userInput) {
        try {
            assert !userInput.isEmpty() : "User input should not be empty";
            Command command = Parser.parse(userInput);
            return command.execute(taskList, storage);
        } catch (DukeException exception) {
            return exception.toString();
        }
    }

}
