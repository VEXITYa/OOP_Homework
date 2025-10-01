package dev.kuchishkin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book("Java Guide", "Author A", 2023, "978-3-16-148410-0");
        book2 = new Book("Java Guide", "Author A", 2023, "978-3-16-148410-0");
    }

    @Test
    void testBookCreation() {
        assertEquals("Java Guide", book1.getTitle());
        assertEquals("Author A", book1.getAuthor());
        assertEquals(2023, book1.getYear());
        assertEquals("978-3-16-148410-0", book1.getISBN());
    }

    @Test
    void testSetTitle() {
        book1.setTitle("New Title");
        assertEquals("New Title", book1.getTitle());

        book1.setTitle(null);
        assertEquals("New Title", book1.getTitle());

        book1.setTitle("");
        assertEquals("New Title", book1.getTitle());
    }

    @Test
    void testSetAuthor() {
        book1.setAuthor("New Author");
        assertEquals("New Author", book1.getAuthor());

        book1.setAuthor(null);
        assertEquals("New Author", book1.getAuthor());

        book1.setAuthor("");
        assertEquals("New Author", book1.getAuthor());
    }

    @Test
    void testSetISBN() {
        book1.setISBN("123-456");
        assertEquals("123-456", book1.getISBN());

        book1.setISBN(null);
        assertEquals("123-456", book1.getISBN());

        book1.setISBN("");
        assertEquals("123-456", book1.getISBN());
    }

    @Test
    void testEqualsAndHashCode() {
        assertEquals(book1, book2);
        assertEquals(book1.hashCode(), book2.hashCode());

        Book book3 = new Book("Python Guide", "Author B", 2021, "183-3-16-563635-0");
        assertNotEquals(book1, book3);
        assertNotEquals(book1.hashCode(), book3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "type: Book, Title: Java Guide, Author: Author A, Year: 2023, ISBN: 978-3-16-148410-0";
        assertEquals(expected, book1.toString());
    }

    @Test
    void testGetType() {
        assertEquals("Book", book1.getType());
    }
}
