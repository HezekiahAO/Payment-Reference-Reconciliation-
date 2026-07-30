package com.flexisaf.paymentrecon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GatewayCsvImporter { // for corrupted row handling

// Imports a gateway-provided CSV of transactions, skipping and logging any corrupted rows rather than failing the whole import.

    public List<GatewayTransaction> importCsv(String filePath) throws IOException {
        List<GatewayTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");

                if (parts.length != 3) {  // Helps me checks the row has exactly the fields expected (reference, amount, date
                    System.out.println("Skipping corrupted row " + lineNumber + ": wrong number of fields -> " + line);
                    continue;
                }

                try {
                    String reference = parts[0];
                    double amount = Double.parseDouble(parts[1]); // i used parseDouble here for better error handling
                    String date = parts[2];

                    transactions.add(new GatewayTransaction(reference, amount, date));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping corrupted row " + lineNumber + ": invalid amount -> " + line);
                }
            }
        }

        return transactions;
    }
}