package org.testingapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;






// Mockito 
// https://www.arhohuttunen.com/junit-5-mockito/





/**
 *  The default instance type is per method.
 *  i.e for every test method, the TestInstance will be created. Hence it is  better to make the beforeAll and afterAll as static.
 *  
 *  If the lifecycle is per class, then the beforeAll and afterAll are executed only once, because the object instances are created only once.
 */
@TestInstance(value = Lifecycle.PER_CLASS)
public class ReverseStringTest {

    public ReverseString rs;

    // If per class instance is created, then we can remove the static.
    @BeforeAll
    static void beforeAll() {
        System.out.println("Doing before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Doing After All");
    }

    @BeforeEach
    void beforeEach() {
        this.rs = new ReverseString();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each invoked");
    }

    @Test
    void testReverse() {
        String reversedString = this.rs.reverse("Abcd");
        assertEquals("dcbA", reversedString);
    }

    @Test
    void testReverse_Multiple() {
        String reversedString = this.rs.reverse("Hola Amigoes");
        assertEquals("seogimA aloH", reversedString);
    }

    @Test
    void testThrowsExample_NoError() {
        String answer = this.rs.throwsExample(5);
        assertNotNull(answer);
    }

    @Test
    void testThrowsExample_withError() {
        assertThrows(IllegalArgumentException.class, () -> this.rs.throwsExample(0));
    }

    @Test
    void testArray() {
        int x[] = { 1, 7, 8 };
        int y[] = this.rs.arraysExample(x);
        assertArrayEquals(x, y);
    }

}
