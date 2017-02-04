package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Association class to indicate the tagging for a person
 *
 */
public class Tagging {
    /**
     * Type of tagging
     */
    public static enum TaggingType {
        ADDING, DELETING
    }


    private final Person _person;
    private final Tag _tag;
    private final TaggingType _type;

    public Tagging(Person person, Tag tag, TaggingType type) {
        this._person = person;
        this._tag = tag;
        this._type = type;
    }

    @Override
    public String toString() {
        return getTaggingTypeString() + " " + _person.toString() + " [" + _tag.toString() + "]";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tagging // instanceof handles nulls
                && toString().equals(((Tagging) other).toString())); // state check
    }

    /**
     * Returns matching string based on the tagging type
     * @return
     */
    private String getTaggingTypeString() {
        return _type == TaggingType.ADDING ? "+" : "-";
    }
}
