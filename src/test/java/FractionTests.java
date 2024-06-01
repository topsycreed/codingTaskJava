import com.mentors.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Fraction class.
 * These tests validate the functionality of the Fraction class.
 * Add additional tests to cover all functionality and edge cases.
 *
 * @author Gennadii Chursov
 */
class FractionTests {

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertEquals(new Fraction(5, 6), result);
    }
}
