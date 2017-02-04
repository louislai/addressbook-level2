package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull_emptyList_returnFalse() {
        assertFalse(Utils.isAnyNull());
    }

    @Test
    public void isAnyNull_nonEmptyListNoNull_returnFalse() {
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));
    }

    @Test
    public void isAnyNull_nonEmptyListOneNullAtBeginning_returnTrue() {
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));
    }

    @Test
    public void isAnyNull_nonEmptyListOneNullInMiddle_returnTrue() {
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));
    }

    @Test
    public void isAnyNull_nonEmptyListOneNullAtLast_returnTrue() {
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));
    }

    @Test
    public void isAnyNull_nullInsideList_returnFalse() {
        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
    }

    @Test
    public void elementsAreUnique_emptyList_areUnique() {
        assertAreUnique();
    }

    @Test
    public void elementsAreUnique_oneObject_areUnique() {
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");
    }

    @Test
    public void elementsAreUnique_multipleDifferentObjects_areUnique() {
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
    }

    @Test
    public void elementsAreUnique_someIdenticalObjects_arentUnique() {
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
