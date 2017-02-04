package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if:
     * - Either they are equal or
     * - If they are unequal, each (case-sensitive) word appears the same
     * number of times in the two names
     *
     * e.g:
     * this word: "John Brown"
     * other word: "Brown John"
     * They are similar because "Brown" & "John" each appear 1 time in each name.
     *
     * @param other
     */
    public boolean isSimilar(Name other) {
        if (equals(other)) {
            return true;
        }

        if (other == null) {
            return false;
        }

        final HashMap<String, Integer> bagOfWords = getBagOfWords();
        final HashMap<String, Integer> otherBagOfWords = other.getBagOfWords();

        for (String key: bagOfWords.keySet()) {
            if (!otherBagOfWords.containsKey(key)
                || bagOfWords.get(key) != otherBagOfWords.get(key)) {
                return false;
            }
        }

        return bagOfWords.keySet().size() == otherBagOfWords.keySet().size();
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    /**
     * Return the dictionary with the frequency of each word in the name
     * @return
     */
    public HashMap<String, Integer> getBagOfWords() {
        String[] words = fullName.split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word: words) {
            if (wordCount.get(word) != null) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        return wordCount;
    }

}
