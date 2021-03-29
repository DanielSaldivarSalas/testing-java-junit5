package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class IndexControllerTest {
    private IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("index.Test Proper View name is returned for index page")
    @Test
    void indexTest() {
        assertEquals("index", indexController.index(),
                "Wrong View Returned");

        assertThat(indexController.index()).isEqualTo("index");

    }

    @Test
    @DisplayName("oppsHandler.throws ValueNotFoundException")
    void oppsHandlerTest() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oppsHandler();
        });
        /*
        assertTrue("notimplemented".equals(indexController.oppsHandler()),
                () -> "This is some expensive" + "message to build"+ "for my tests");
        */
    }
}