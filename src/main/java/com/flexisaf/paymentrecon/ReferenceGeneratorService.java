package com.flexisaf.paymentrecon;

public class ReferenceGeneratorService {
    
    // Given an invoiceId, generate a unique reference number using Luhn's algorithm(base digit + check digit) and return it as a string.
    
    private ChecksumCalculator checksumCalculator = new ChecksumCalculator();
    
    public String generateReference(Invoice invoice) {
        // Implementation for generating reference number
        
        int baseDigit = invoice.getInvoiceId(); // Use invoiceId as the base digit
        int checkDigit = checksumCalculator.calculateCheckDigit(baseDigit);

        return "" + baseDigit + checkDigit; // Concatenate base digit and check digit to form the reference number
    }

}
