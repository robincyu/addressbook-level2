package seedu.addressbook.commands;

/**
 * Sorts the address book.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the address book. "
            + "Sorts in ascending order of name by default, pass 'desc' to sort descending.\n"
            + "Parameters: [desc]\n"
            + "Example: " + COMMAND_WORD
            + " desc";

    private static final String MESSAGE_SUCCESS = "Address book sorted in %1$s order.";
    private static final Boolean ASCENDING = true;
    private static final Boolean DESCENDING = false;

    public SortCommand(boolean sortOrder) {
        if (sortOrder == ASCENDING) {
            System.out.println("Hello, the value of SortOrder is: " + sortOrder);
        }
        if (sortOrder == DESCENDING) {
            System.out.println("Hello, the value of SortOrder is: " + sortOrder);
        }
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
