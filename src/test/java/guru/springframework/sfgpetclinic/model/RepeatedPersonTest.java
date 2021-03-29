package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedPersonTest implements ModelTests{

    @BeforeEach
    void setUp() {
    }

    @RepeatedTest(value = 10)
    @DisplayName("Person Repeated Test")
    void getFirstName(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " " + repetitionInfo.getCurrentRepetition());
    }
}