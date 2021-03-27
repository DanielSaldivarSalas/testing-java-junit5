package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void groupedAssertionsTest() {
        //given
        Person person = new Person(1L, "Daniel", "Saldivar");

        //then
        assertAll("Test Property Set",
                ()-> assertEquals("Daniel", person.getFirstName(), "First Named Failed"),
                () -> assertEquals("Saldivar",person.getLastName(),"Second Named Failed"));
    }
}