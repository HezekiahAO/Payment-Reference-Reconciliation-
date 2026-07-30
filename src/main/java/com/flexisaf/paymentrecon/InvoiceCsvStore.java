package com.flexisaf.paymentrecon;

import java.io.*;  // importing all available classes and interfaces from the Java Input/Output (java.io) package
import java.util.ArrayList;
import java.util.List;

public class InvoiceCsvStore {
                                                                // input output exceptions
    public void save(List<Invoice> invoices, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Invoice inv : invoices) {
                writer.println(inv.getInvoiceId() + "," + inv.getPayerId() + "," + inv.getAmount() + "," + inv.getStatus());
            }
        }
    }

    public List<Invoice> load(String filePath) throws IOException {
        List<Invoice> invoices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int invoiceId = Integer.parseInt(parts[0]);
                int payerId = Integer.parseInt(parts[1]);
                double amount = Double.parseDouble(parts[2]);
                String status = parts[3];

                invoices.add(new Invoice(invoiceId, payerId, amount, status));
            }
        }

        return invoices;
    }
}