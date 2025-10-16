import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestStringCalculator {

    @Test
    public void testStringVoid(){
        StringCalculator c = new StringCalculator();
        assertEquals(0, c.add(""));
    }

    @Test
    public void testStringUniqueNumber(){
        StringCalculator c = new StringCalculator();
        String number = "1";
        assertEquals(1, c.add(number));
    }

    @Test
    public void testStringTwoNumbers1(){
        StringCalculator c = new StringCalculator();
        String number = "1,2";
        assertEquals(3, c.add(number));
    }

    @Test
    public void testStringTwoNumbers2(){
        StringCalculator c = new StringCalculator();
        String number = "55,2";
        assertEquals(57, c.add(number));
    }

    @Test
    public void testStringLotNumbers(){
        StringCalculator c = new StringCalculator();
        String number = "55,2,1,4";
        assertEquals(62, c.add(number));
    }

    @Test
    public void testStringWithLines(){
        StringCalculator c = new StringCalculator();
        String number = "1\n2,3";
        assertEquals(6,c.add(number));
    }

    @Test
    public void testStringNewDelimiter(){
        StringCalculator c = new StringCalculator();
        String number = "//;\n1;2";
        assertEquals(3,c.add(number));
    }    
    
    @Test
    public void testStringNegative(){
        StringCalculator c = new StringCalculator();
        String aux = "-1,2";
        assertThrows(IllegalArgumentException.class, () -> {
            c.add(aux);
        });
    }

    @Test
    public void testAddCount(){
        StringCalculator c = new StringCalculator();
        String number1 = "//;\n1;2";
        String number2 = "1,2";
        c.add(number1);
        c.add(number2);
        assertEquals(2,c.GetCalledCount());
    }

    @Test
    public void testBigNumbers(){
        StringCalculator c = new StringCalculator();
        String number = "1001,2";
        assertEquals(2, c.add(number));
    }

    @Test
    public void testBigDelimiter(){
        StringCalculator c = new StringCalculator();
        String number = "//[***]\n1***2***3";
        assertEquals(6,c.add(number));    
    }

    @Test
    public void testMoreDelimiters(){
        StringCalculator c = new StringCalculator();
        String number = "//[*][%]\n1*2%3";
        assertEquals(6,c.add(number));    
    }


}




