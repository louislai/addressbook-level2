package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class TextFormatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /**
     * Format the command message that asks the user to enter a new command
     * @param commandMessage is the raw command message
     * @return the formatted command message
     */
    public String formatCommandMessage(String commandMessage) {
        return LS + commandMessage;
    }
    
    /**
     * Format the log of an input
     * @param input is the command that was issued by the user
     * @return the formatted input log
     */
    public String formatCommandLog(String input) {
        return "[Command entered:" + input + "]";
    }
    
    /**
     * Return a welcome message based on version & storageFilePath
     * @param version
     * @param storageFilePath
     * @return the formatted welcome message
     */
    public String formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return DIVIDER + DIVIDER +MESSAGE_WELCOME + version +
               MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + storageFileInfo + DIVIDER;
    }
    
    /**
     * Return a formatted goodbye message
     * @return the goodbye message
     */
    public String formatGoodbyeMessage() {
        return MESSAGE_GOODBYE + DIVIDER + DIVIDER;
    }
    
    /**
     * Return a formatted init failure message
     * @return the init failure message
     */
    public String formatInitFailedMessage() {
        return MESSAGE_INIT_FAILED + DIVIDER + DIVIDER;
    }
    
    /**
     * Format a message to be shown to user
     * @param message
     * @return formatted message
     */
    public String formatMessage(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    /**
     * Format the result to user
     * @param resultMessage
     * @return formatted result message
     */
    public String formatResultMessage(String resultMessage) {
        return resultMessage + DIVIDER;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
