package duke.duke;

/**
 * A dedicated Exception class for Duke program.
 *
 */
public class DukeException extends Exception {
    public DukeException(String errorMessage) {
        super(errorMessage);
        assert !errorMessage.isEmpty() : "Error message should not be empty";
    }

    /**
     * Returns a string representation of the exception.
     *
     * @return The Exception message.
     */
    @Override
    public String toString() {
        return super.getMessage();
    }
}
