import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime endDate;

    public Deadline(String taskName, String endDate) throws DukeException{
        super(taskName);
        try {
            this.endDate = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"));
        } catch (DateTimeParseException dateTimeParseException){
            throw new DukeException("☹ OOPS!!! Cannot parse date. Enter date according to example, 02-12-2019 1800");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.endDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String toFileString() {
        return "D" + "|" + (this.getTaskStatus() ? "1" : "0") + "|" + this.getTaskName() + "|" + this.endDate;
    }
}
