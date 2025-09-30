package dev.kuchishkin.library;

import dev.kuchishkin.model.Book;
import dev.kuchishkin.model.Magazine;
import dev.kuchishkin.model.Newspaper;
import dev.kuchishkin.model.Publication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Magazine magazine1;
    private Newspaper newspaper1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String ls = System.lineSeparator();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));

        library = new Library();

        book1 = new Book("Java Guide", "Author A", 2025, "123-456");
        book2 = new Book("Python Guide", "Author B", 2022, "789-012");
        magazine1 = new Magazine("Tech Today", "Editor A", 2023, 5);
        newspaper1 = new Newspaper("Daily News", "Reporter A", 2023, "Monday");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    void testListPublicationsOutput() {
        library.addPublication(book1);
        library.addPublication(magazine1);

        library.listPublications();

        String expectedOutput = "Publications:" + ls +
                book1.toString() + ls +
                magazine1.toString() + ls + ls;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchByAuthorOutput() {
        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(magazine1);

        library.searchByAuthor("Author A");

        String expectedOutput = "Found Publications by Author:" + ls +
                book1.toString() + ls + ls;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchByTitleOutput() {
        library.addPublication(book1);
        library.addPublication(book2);

        library.searchByTitle("Java Guide");

        String expectedOutput = "Found Publications by Title:" + ls +
                book1.toString() + ls + ls;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchByYearOutput() {
        library.addPublication(book1);
        library.addPublication(book2);

        library.searchByYear(2025);

        String expectedOutput = "Found Publications by Year:" + ls +
                book1.toString() + ls + ls;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testAddPublication() {
        library.addPublication(book1);
        library.addPublication(magazine1);

        assertEquals(2, librarySize());

        library.addPublication(book1);
        assertEquals(2, librarySize());
    }

    @Test
    void testAddNullPublication() {
        library.addPublication(null);
        assertEquals(0, librarySize());
    }


    private int librarySize() {
        return ((ArrayList<Publication>) getPublicationsField(library)).size();
    }

    private List<Publication> getPublicationsField(Library lib) {
        try {
            var field = Library.class.getDeclaredField("publications");
            field.setAccessible(true);
            return (List<Publication>) field.get(lib);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}