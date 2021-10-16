package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    public void sumOfTwoInteger(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    @Test
    public void addNumbersWithNewLine(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
    @Test
    public void supportDifferentDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(4, stringCalculator.add("//;\n1;3"));
    }
    @Test
    public void negativeNumberShouldThrowException() {
        StringCalculator stringCalculator = new StringCalculator();
        try {
            stringCalculator.add("//;\n-1;3");
        } catch (RuntimeException e) {
            String x = "negatives not allowed - ";
            assertEquals(x, e.getMessage().substring(0,x.length()));
        }
    }
    @Test
    public void getAddCalledCount() {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("//;\n1;3");
        assertEquals(1, stringCalculator.getCalledCount());
    }
    @Test
    public void greaterThanThousandShouldIgnored() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2,1001"));
    }
}
