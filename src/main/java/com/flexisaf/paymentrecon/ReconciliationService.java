package com.flexisaf.paymentrecon;

import java.util.List;

public class ReconciliationService {
    
    private ReferenceGeneratorService referenceGenerator = new ReferenceGeneratorService();

    public void reconcile(List<Invoice> invoices, List<PaymentRecord> payments) {

        for (PaymentRecord payment : payments) {
            Invoice matchedInvoice = null;


        // finding the invoice whose generated reference equals payment.getReference()
        for (Invoice inv : invoices) {
            String invoiceReference = referenceGenerator.generateReference(inv);
            if (invoiceReference.equals(payment.getReference())) {
                matchedInvoice = inv;
                break;
            } 
        }

    // If they match, classify them.
        if (matchedInvoice == null){
            System.out.println("UNMATCHED: payment ref " + payment.getReference() + " has no matching invoice");
        } 
        else if  (matchedInvoice.getAmount() == payment.getAmountPaid()){
            System.out.println("MATCHED: payment ref " + payment.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId());
        }
        else {
            System.out.println("MISMATCH: payment ref " + payment.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId() +
                            " but amount differs (expected " + matchedInvoice.getAmount() + ", got " + payment.getAmountPaid() + ")");
            }
        }
    }
}