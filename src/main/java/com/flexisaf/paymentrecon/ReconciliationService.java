package com.flexisaf.paymentrecon;
// the part that Matches recorded payments (PaymentRecord) and gateway transactions
import java.util.List;

public class ReconciliationService {
    
    private ReferenceGeneratorService referenceGenerator = new ReferenceGeneratorService();
                                    // compares payment record and Invoice
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
            if (matchedInvoice == null) {
                System.out.println("UNMATCHED: payment ref " + payment.getReference() + " has no matching invoice");
            } 
            else if (matchedInvoice.getAmount() == payment.getAmountPaid()) {
                System.out.println("MATCHED: payment ref " + payment.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId());
            } 
            else {
                System.out.println("MISMATCH: payment ref " + payment.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId() +
                        " but amount differs (expected " + matchedInvoice.getAmount() + ", got " + payment.getAmountPaid() + ")");
            }
        }
    }
    // reconcilation for 3rd party platforms
    public void reconcileGatewayTransactions(List<Invoice> invoices, List<GatewayTransaction> transactions) {
        for (GatewayTransaction txn : transactions) {
            Invoice matchedInvoice = null;

            for (Invoice inv : invoices) {
                String invoiceReference = referenceGenerator.generateReference(inv);
                if (invoiceReference.equals(txn.getReference())) {
                    matchedInvoice = inv;
                    break;
                }
            }

            if (matchedInvoice == null) {
                System.out.println("UNMATCHED (gateway): txn ref " + txn.getReference() + " has no matching invoice");
            } else if (matchedInvoice.getAmount() == txn.getAmount()) {
                System.out.println("MATCHED (gateway): txn ref " + txn.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId());
            } else {
                System.out.println("MISMATCH (gateway): txn ref " + txn.getReference() + " matches Invoice " + matchedInvoice.getInvoiceId() +
                        " but amount differs (expected " + matchedInvoice.getAmount() + ", got " + txn.getAmount() + ")");
            }
        }
    }
}