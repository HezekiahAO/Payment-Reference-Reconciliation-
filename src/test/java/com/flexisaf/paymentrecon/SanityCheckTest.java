package com.flexisaf.paymentrecon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SanityCheckTest {

    @Test
    void testingIfMavenAndJUnitAreWiredUpCorrectly() {
        assertEquals(4, 2 + 2, "If this fails, something is very wrong with arithmetic itself.");
    }
}
