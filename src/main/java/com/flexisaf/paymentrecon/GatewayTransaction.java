package com.flexisaf.paymentrecon;

public class GatewayTransaction { // 3rd party record used to cross-check against our own invoice registry during reconciliation.
    private String reference;
    private double amount;
    private String transactionDate;

    public GatewayTransaction(String reference, double amount, String transactionDate) {
        this.reference = reference;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getReference() {
        return reference;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "GatewayTransaction{" +
                "reference='" + reference + '\'' +
                ", amount=" + amount +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}