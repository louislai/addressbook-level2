package seedu.addressbook.data.person;

/**
 * Public interface that provides a printable string method
 */
public interface Printable {
    
    /**
     * Return a printable string
     * @return
     */
    default String getPrintableString() {
        return getClass().getSimpleName() + ": " + toString();
    }
}
