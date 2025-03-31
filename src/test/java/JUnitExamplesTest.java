import org.junit.jupiter.api.*;

public class JUnitExamplesTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }


    @Test
    void firstTest() {
        System.out.println("First Test");
    }

    @Test
    void secondTest() {
        System.out.println("Second Test");
    }

}


