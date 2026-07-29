package com.flexisaf.paymentrecon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChecksumCalculatorTest {
                                    //.\mvnw.cmd test
    @Test
    void knownBaseNumberProducesExpectedCheckDigit(){
        ChecksumCalculator calculator = new ChecksumCalculator();
        int result = calculator.calculateCheckDigit(2345564);  // int = data type, result = varible, calculator is an obj using the dot operator to call a method to access the method capabilities of that method and then an argument is passed(value to work with(input)).
        assertEquals(5, result); // expected, actualresult

    }

}