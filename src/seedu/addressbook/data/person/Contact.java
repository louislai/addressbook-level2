package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public static String MESSAGE_CONTACT_CONSTRAINTS = "Contact can be anything";
    public static String CONTACT_VALIDATION_REGEX = ".*";
    
    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given contact.
     * Constraints can be changed in subclass if necessary
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Contact(String value, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        checkValidValue(trimmedValue);
        this.value = trimmedValue;
    }

    /**
     * Checks if a given string is a valid person email.
     */
    public static boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }
    
    /**
     * Check if a particular value supplied to the constructor is valid
     * @param value
     * @throws IllegalValueException if given value string is invalid.
     */
    protected void checkValidValue(String value) throws IllegalValueException {
        if (!isValidContact(value)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other != null && other.getClass() == this.getClass()
                && this.value.equals(((Contact) other).value)); // state check
    }
}
