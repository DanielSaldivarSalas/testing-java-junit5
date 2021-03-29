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
                ()-> assertEquals("Daniel", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Saldivar",person.getLastName(),"Second Name Failed"));
    }
    @Test
    void settersGroupedAssertionsTest() {
        //given
        Person person = new Person(1L, "Daniel", "Saldivar");

        //when
        person.setFirstName("Python");
        person.setLastName("Lover");

        //then
        assertAll("Test Property Set",
                ()-> assertNotEquals("Daniel", person.getFirstName(), "First Name did not changed with setter"),
                () -> assertNotEquals("Saldivar",person.getLastName(),"Second Name did not change with setter"),
                ()-> assertEquals("Python", person.getFirstName(), "First Name does not have correct value"),
                () -> assertEquals("Lover",person.getLastName(),"Second Name does not have correct value"));
    }
}