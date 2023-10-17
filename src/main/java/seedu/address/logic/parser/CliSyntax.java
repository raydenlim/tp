package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_GRADED_TEST = new Prefix("gt/");
    public static final Prefix PREFIX_READING_ASSESSMENT = new Prefix("gt/ra/");
    public static final Prefix PREFIX_MIDTERMS = new Prefix("gt/m/");
    public static final Prefix PREFIX_FINALS = new Prefix("gt/f/");
    public static final Prefix PREFIX_PRACTICAL_EXAM = new Prefix("gt/pe/");

    public static final Prefix PREFIX_TASK_NAME = new Prefix("tn/");
    public static final Prefix PREFIX_TASK_DESCRIPTION = new Prefix("td/");

}
