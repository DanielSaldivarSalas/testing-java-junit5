package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    private IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void indexTest() {
        assertEquals("index", indexController.index(),
                "Wrong View Returned");

    }

    @Test
    void oupsHandlerTest() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()),
                () -> "This is some expensive" + "message to build"+ "for my tests");
    }
}