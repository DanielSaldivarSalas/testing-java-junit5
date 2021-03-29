package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");
        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName()),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "[{index}] {arguments} - super cool")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val){
        System.out.println("Hello there - " + val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType){
        System.out.println("Hello from Enum - " + ownerType);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest
    @CsvSource({
        "FL,1,3",
        "OH,2,4",
        "MI,3,5"
    })
    void testCsvSource(String stateName, int val1, int val2) {
        System.out.println("Hello from " + stateName + " : " + (val1 + val2));
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv",numLinesToSkip = 1 ) //numLinesToSkip=1 to skip header record
    void testCsvFile(String stateName, int val1, int val2) {
        System.out.println("Hello from CSV File " + stateName + " : " + (val1 + val2));
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println("Hello from CSV File " + stateName + " : " + (val1 + val2));
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
            Arguments.of("FL", 1 ,2),
            Arguments.of("OH", 3 ,4),
            Arguments.of("FL", 5 ,6)
        );
    }


    @DisplayName("Custom Provider Test")
    @ParameterizedTest
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println("Hello from CSV File " + stateName + " : " + (val1 + val2));
    }
}