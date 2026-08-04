package com.flexisaf.paymentrecon;  // The goal of this file is to serve as an entry point.

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Luhn's Algorithm                                         //Everything that "does something" (creates objects, loops, prints) needs to be inside main's curly braces { }, not after its closing }.
public class Main { 
    public static void main(String[] args) {
// Structuring around switch so that i can use a sincgle run commands.
        String command = (args.length > 0) ? args[0] : "run";
// if an argument was actually given, use it; otherwise, just default to run.
        switch (command) {
            case "run":
                runFullDemo();
                break;
                default:
                    System.out.println("Unknown command" + command);
        }
    }


    private static void runFullDemo() {
        List<Invoice> invoices = new ArrayList<>();  // new array to hold and grow collection\
        // and i am using generic type to specify the type of objects that the list will hold and i can easily debug, which is Invoice in this case.
        invoices.add(new Invoice(1, 1001, 250.75, "Unpaid"));
        invoices.add(new Invoice(2, 1002, 150.50, "Paid"));
        invoices.add(new Invoice(3, 1003, 300.00, "Unpaid"));

        for (Invoice x : invoices) {
            System.out.println(x);
        }

        ReferenceGeneratorService referenceGenerator = new ReferenceGeneratorService();

        for (Invoice x : invoices) {
            String reference = referenceGenerator.generateReference(x);
            System.out.println("Generated reference for Invoice " + x.getInvoiceId() + ", Reference: " + reference);
        }

        List<PaymentRecord> paymentRecords = new ArrayList<>();
        String firstReference = referenceGenerator.generateReference(invoices.get(0));
        paymentRecords.add(new PaymentRecord(firstReference, 250.75, "2026-6-04"));

        for (PaymentRecord p : paymentRecords) {
            System.out.println(p);
        }

        ReconciliationService reconciliationService = new ReconciliationService();  // instance of reconcilation
        reconciliationService.reconcile(invoices, paymentRecords);

        InvoiceCsvStore invoiceStore = new InvoiceCsvStore();

        try {
            invoiceStore.save(invoices, "invoice.csv");
            System.out.println("Invoices saved to invoice.csv");
        } catch (IOException error) {
            System.out.println("Failed to save invoices: " + error.getMessage());
        }

        try {
            List<Invoice> loadedInvoices = invoiceStore.load("invoice.csv");
            System.out.println("Loaded invoices from file:");
            for (Invoice inv : loadedInvoices) {
                System.out.println(inv);
            }
        } catch (IOException error) {
            System.out.println("Failed to load invoices: " + error.getMessage());
        }

        GatewayCsvImporter importer = new GatewayCsvImporter();
        try {
            List<GatewayTransaction> transactions = importer.importCsv("gateway.csv");
            System.out.println("Imported gateway transactions:");
            for (GatewayTransaction t : transactions) {
                System.out.println(t);
            }
            
        reconciliationService.reconcileGatewayTransactions(invoices, transactions);

        } catch (IOException e) {
            System.out.println("Failed to import gateway CSV: " + e.getMessage());
        }

        
        PaymentRecordCsvStore paymentStore = new PaymentRecordCsvStore();
        try {
            paymentStore.save(paymentRecords, "payments.csv");
            System.out.println("Payments saved to payments.csv");

            List<PaymentRecord> loadedPayments = paymentStore.load("payments.csv");
            System.out.println("Loaded payments from file:");
            for (PaymentRecord p : loadedPayments) {
                System.out.println(p);
            }
        } catch (IOException e) {
            System.out.println("Failed to save/load payments: " + e.getMessage());
        }

    }
}