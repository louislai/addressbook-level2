package seedu.addressbook.data.person;

public class PostalCode {
    public final String value;

    public PostalCode(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }
}
