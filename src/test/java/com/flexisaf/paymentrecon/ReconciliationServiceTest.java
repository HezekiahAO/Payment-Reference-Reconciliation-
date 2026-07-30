package com.flexisaf.paymentrecon;


// Test case for reconcilation: so testing different instances and units of the code.
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ReconciliationServiceTest {

    @Test
    void matchedPaymentDoesNotThrow() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(4821, 1001, 100.0, "Unpaid"));

        List<PaymentRecord> payments = new ArrayList<>();
        payments.add(new PaymentRecord("48219", 100.0, "2026-07-30"));

        ReconciliationService service = new ReconciliationService();
        service.reconcile(invoices, payments); // just confirms no crash for now
    }
}