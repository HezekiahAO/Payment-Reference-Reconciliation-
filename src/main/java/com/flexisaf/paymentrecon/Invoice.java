// This (Invoice) represent the money owned by a person or we can say a buyer who wants to pay for a goods he bought.

package com.flexisaf.paymentrecon;

public class Invoice {

        private int invoiceId;
        private int payerId; // creating mutiple fields
        private double amount;
        private String status;

        public Invoice(int invoiceId, int payerId, double amount, String status) {
            this.invoiceId = invoiceId;
            this.payerId = payerId;
            this.amount = amount;     // Instantiate the every of this my private fields(constructor).
            this.status = status;


            System.out.println("Invoice created with ID: " + invoiceId);
        }

    public int getInvoiceId() {
        // A getter that let me read the values of the private fields of the Invoice object without changing it.
        return invoiceId;
    }

    public int getPayerId() {
        return payerId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

@Override
public String toString() {
    return "Invoice{" +
            "invoiceId=" + invoiceId +
            ", payerId=" + payerId +
            ", amount=" + amount +
            ", status='" + status + '\'' +
            '}';

    }
}