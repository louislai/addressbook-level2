package seedu.addressbook.parser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

/**
 * Test cases for Names (specifically to check for isSimilar method)
 */


public class NameTest {


    private Name name1;
    private Name name2;
    private Name name3;
    private Name name4;
    @Before
    public void setUp() throws IllegalValueException {
        name1 = new Name("John Brown");
        name2 = new Name("Brown John");
        name3 = new Name("john brown");
        name4 = new Name("kattis");
    }

    @Test
    public void isSimilar_nameAndNull_areNotSimilar() {
        assertFalse(name1.isSimilar(null));
    }

    @Test
    public void isSimilar_equalNames_areSimilar() {
        assertTrue(name1.isSimilar(name1));
    }

    @Test
    public void isSimilar_namesWithSameWords_areSimilar() {
        assertTrue(name1.isSimilar(name2));
    }

    @Test
    public void isSimilar_namesWithSameWordsDifferentCase_arentSimilar() {
        assertFalse(name1.isSimilar(name3));
    }

    @Test
    public void isSimilar_differentNames_arentSimilar() {
        assertFalse(name1.isSimilar(name4));
    }
}
