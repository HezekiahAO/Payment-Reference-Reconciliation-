package com.flexisaf.paymentrecon;


// Luhn's Algorithm
public class ChecksumCalculator {

    public int calculateCheckDigit(int baseDigit) {
        String digits = String.valueOf(baseDigit);
        int total = 0;

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(digits.length() - 1 - i));

            if (i % 2 == 1) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            total += digit;
        }

        return (10 - total % 10) % 10;
    }
}