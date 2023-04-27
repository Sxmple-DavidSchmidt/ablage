package test.util;
import main.util.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void my_fibonacci_test() {
        assertEquals(MyMath.fibonacci(0), 0);
        assertEquals(MyMath.fibonacci(7), 13);
    }

    @Test
    void my_addition_test() {
        assertEquals(MyMath.add(10, 2), 12);
        assertEquals(MyMath.add(0, 0), 0);
        assertEquals(MyMath.add(7, -2), 5);

    }

    @Test
    void my_findNumberInArray_test() {
        assertEquals(
                MyMath.findNumberInArray(2, new int[0]),
                -1
        );
    }
}