package exer;

import org.apache.commons.validator.GenericValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateEntryTest{

    private static DateEntry dateEntry;

    private static String sampleInput = "2019-12-10";

    @BeforeAll
    static void beforeAll() {
        dateEntry = new DateEntry(sampleInput);
    }

    @Test
    void isDateStartMonth()  {
        try {
            assertFalse(dateEntry.isDateStartMonth());
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    void isDateEndMonth() {
        try {
            assertFalse(dateEntry.isDateEndMonth());
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    void isMonthFirstHalf() {
        try {
            assertFalse(dateEntry.isMonthFirstHalf());
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    void isMonthLastHalf() {
        try {
            assertFalse(dateEntry.isMonthLastHalf());
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }


    @Test
    void validateDate() throws Exception {
        try {
            dateEntry.validateDate();
        } catch (Exception e) {
            assertEquals("The input date is invalid!", e.getMessage());
        }
    }
}