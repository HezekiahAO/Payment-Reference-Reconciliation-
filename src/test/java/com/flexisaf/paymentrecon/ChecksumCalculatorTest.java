package com.flexisaf.paymentrecon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChecksumCalculatorTest {
                                    //    .\mvnw.cmd test
    
    private final ChecksumCalculator calculator = new ChecksumCalculator();  // final makes sure once a variable is assigned to this, it can never be reassigned.
    @Test
    void knownBaseNumberProducesExpectedCheckDigit(){
        ChecksumCalculator calculator = new ChecksumCalculator();
        int result = calculator.calculateCheckDigit(2345564);  // int = data type, result = varible, calculator is an obj using the dot operator to call a method to access the method capabilities of that method and then an argument is passed(value to work with(input)).
        assertEquals(5, result); // expected, actualresult
        
    }
    @Test
    void secondKnownBaseNumberProducesExpectedCheckDigit() {
        assertEquals(9, calculator.calculateCheckDigit(4821));
    }

    @Test
    void singleDigitTypoChangesCheckDigit() {
        int originalCheckDigit = calculator.calculateCheckDigit(4821);
        int typoCheckDigit = calculator.calculateCheckDigit(4871); // one digit changed
        assertEquals(false, originalCheckDigit == typoCheckDigit);
    }
}