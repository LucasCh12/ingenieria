import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFizzBuzz {
    
    @Test
    public void testIsFizz(){
        int aux = 3;
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.isFizz(aux));
    }

    @Test
    public void testIsBuzz(){
        int aux = 5;
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.isBuzz(aux));
    }

    @Test
    public void testContains3(){
        int aux = 13;
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.contains3(aux));
    }

    @Test
    public void testContains5(){
        int aux = 15;
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.contains5(aux));
    }

    @Test
    public void isNumber(){
        int aux = 1;
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.isNumber(aux));
    }

    @Test
    public void test35(){
        int aux = 35;
        FizzBuzz f = new FizzBuzz();
        assertEquals("FizzBuzzBuzz", f.fizzBuzzOutputI(aux));
    }

    
    @Test
    public void test15(){
        int aux = 15;
        FizzBuzz f = new FizzBuzz();
        assertEquals("BuzzFizzBuzz", f.fizzBuzzOutputI(aux));
    }

}
