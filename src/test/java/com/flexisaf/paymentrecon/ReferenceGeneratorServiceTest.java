package com.flexisaf.paymentrecon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReferenceGeneratorServiceTest {

    @Test
    void generatedReferenceEndsWithCorrectCheckDigit() {
        Invoice invoice = new Invoice(4821, 1001, 100.0, "Unpaid");
        ReferenceGeneratorService generator = new ReferenceGeneratorService();

        String reference = generator.generateReference(invoice);

        assertEquals("48219", reference); // base 4821 + check digit 9, verified earlier
    }
}