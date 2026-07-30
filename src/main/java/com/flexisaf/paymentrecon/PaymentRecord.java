// My internal logs or transactions

package com.flexisaf.paymentrecon;

public class PaymentRecord {
    private String reference;
    private double amountPaid;
    private String dateRecorded;

    public PaymentRecord(String reference, double amountPaid, String dateRecorded) {
        this.reference = reference;
        this.amountPaid = amountPaid;
        this.dateRecorded = dateRecorded;
    }

    public String getReference() {
        return reference;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getDateRecorded() {
        return dateRecorded;
    }

@Override
public String toString() {
    return "PaymentRecord{" +
            "reference='" + reference + '\'' +
            ", amountPaid=" + amountPaid +
            ", dateRecorded='" + dateRecorded + '\'' +
            '}';
    }
}
