package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("person")
public interface ModelTests {
    @BeforeAll
    default void beforeAll(){
        System.out.println("Hello within interface!");
    }
}
