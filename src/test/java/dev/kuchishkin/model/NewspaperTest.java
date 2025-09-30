package dev.kuchishkin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

public class NewspaperTest {

    private Newspaper newspaper1;
    private Newspaper newspaper2;

    @BeforeEach
    void setUp() throws Exception {
        newspaper1 = new Newspaper("Daily News", "Reporter A", 2025, "Monday");
        newspaper2 = new Newspaper("Daily News", "Reporter A", 2025, "Monday");
    }

    @Test
    void testNewspaperCreation() {
        assertEquals("Daily News", newspaper1.getTitle());
        assertEquals("Reporter A", newspaper1.getAuthor());
        assertEquals(2025, newspaper1.getYear());
        assertEquals("Monday", newspaper1.getPublicationDay());
    }

    @Test
    void testSetPublicationDay() {
        newspaper1.setPublicationDay("Friday");
        assertEquals("Friday", newspaper1.getPublicationDay());

        newspaper1.setPublicationDay(null);
        assertEquals("Friday", newspaper1.getPublicationDay());

        newspaper1.setPublicationDay("");
        assertEquals("Friday", newspaper1.getPublicationDay());
    }

    @Test
    void testGetType() {
        assertEquals("Newspaper", newspaper1.getType());
    }

    @Test
    void testEqualsAndHashCode() {
        assertEquals(newspaper1, newspaper2);
        assertEquals(newspaper1.hashCode(), newspaper2.hashCode());

        Newspaper newspaper3 = new Newspaper("Daily News", "Reporter A", 2023, "Tuesday");
        assertNotEquals(newspaper1, newspaper3);
        assertNotEquals(newspaper1.hashCode(), newspaper3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "type: Newspaper, Title: Daily News, Author: Reporter A, Year: 2025, publicationDay: Monday";
        assertEquals(expected, newspaper1.toString());
    }
}
