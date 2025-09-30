package dev.kuchishkin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MagazineTest {

    private Magazine magazine1;
    private Magazine magazine2;

    @BeforeEach
    void setUp() {
        magazine1 = new Magazine("Tech Today", "Editor A", 2025, 135);
        magazine2 = new Magazine("Tech Today", "Editor A", 2025, 135);
    }

    @Test
    void testBookCreation() {
        assertEquals("Tech Today", magazine1.getTitle());
        assertEquals("Editor A", magazine1.getAuthor());
        assertEquals(2025, magazine1.getYear());
        assertEquals(135, magazine1.getIssueNumber());
    }

    @Test
    void testSetTitle() {
        magazine1.setTitle("New Title");
        assertEquals("New Title", magazine1.getTitle());

        magazine1.setTitle(null);
        assertEquals("New Title", magazine1.getTitle());

        magazine1.setTitle("");
        assertEquals("New Title", magazine1.getTitle());
    }

    @Test
    void testSetAuthor() {
        magazine1.setAuthor("New Author");
        assertEquals("New Author", magazine1.getAuthor());

        magazine1.setAuthor(null);
        assertEquals("New Author", magazine1.getAuthor());

        magazine1.setAuthor("");
        assertEquals("New Author", magazine1.getAuthor());
    }

    @Test
    void testSetIssueNumber() {
        magazine1.setIssueNumber(5);
        assertEquals(5, magazine1.getIssueNumber());

        magazine1.setIssueNumber(0);
        assertEquals(5, magazine1.getIssueNumber());

        magazine1.setIssueNumber(-15);
        assertEquals(5, magazine1.getIssueNumber());
    }

    @Test
    void testEqualsAndHashCode() {
        assertEquals(magazine1, magazine2);
        assertEquals(magazine1.hashCode(), magazine2.hashCode());

        Magazine magazine3 = new Magazine("Tech Yesterday", "Editor B", 2024, 17);
        assertNotEquals(magazine1, magazine3);
        assertNotEquals(magazine1.hashCode(), magazine3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "type: Magazine, Title: Tech Today, Author: Editor A, Year: 2025, issueNumber: 135";
        assertEquals(expected, magazine1.toString());
    }

    @Test
    void testGetType() {
        assertEquals("Magazine", magazine1.getType());
    }
}
