import org.example.selu.StreamPractice.NumbersStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberStreamTest {

    @Test
    public void testPrime() {
        assertTrue(NumbersStream.isPrimeNonStream(2));
        assertTrue(NumbersStream.isPrimeNonStream(3));
        assertFalse(NumbersStream.isPrimeNonStream(4));
        assertTrue(NumbersStream.isPrimeNonStream(5));
        assertFalse(NumbersStream.isPrimeNonStream(6));
        assertTrue(NumbersStream.isPrimeNonStream(7));
        assertFalse(NumbersStream.isPrimeNonStream(8));
    }
}
