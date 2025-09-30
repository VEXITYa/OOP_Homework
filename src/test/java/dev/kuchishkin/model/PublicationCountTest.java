package dev.kuchishkin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublicationCountTest {
    @BeforeEach
    void resetCount() throws Exception {
        Field field = Publication.class.getDeclaredField("publicationCount");
        field.setAccessible(true);
        field.set(null, 0);
    }

    @Test
    void testPublicationCount() {
        assertEquals(0, Publication.getPublicationCount());

        new Book("Test Book", "Test Author", 2020, "123");
        assertEquals(1, Publication.getPublicationCount());
    }
}
