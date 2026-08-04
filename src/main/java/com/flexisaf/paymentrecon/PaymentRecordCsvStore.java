package com.flexisaf.paymentrecon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//  Saves/loads PaymentRecord data to/from a CSV file, enabling persistence between runs.
public class PaymentRecordCsvStore {

    public void save(List<PaymentRecord> payments, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (PaymentRecord p : payments) {
                writer.println(p.getReference() + "," + p.getAmountPaid() + "," + p.getDateRecorded());
            }
        }
    }

    public List<PaymentRecord> load(String filePath) throws IOException {
        List<PaymentRecord> payments = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String reference = parts[0];
                double amountPaid = Double.parseDouble(parts[1]);
                String dateRecorded = parts[2];

                payments.add(new PaymentRecord(reference, amountPaid, dateRecorded));
            }
        }

        return payments;
    }
}