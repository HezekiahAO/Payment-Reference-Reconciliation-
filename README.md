# Payment Reference & Reconciliation.

A Java-based system for generating checksum-verified payment references, recording payments, and reconciling them against invoices, including imported gateway (bank/3rd party) transactions.

## Tech Stack
- Java 17+
- Maven (with Maven Wrapper, no local Maven install required, run via `mvnw.cmd` / `mvnw`)
- JUnit 5
- Storage: CSV

## How to Run
```
.\mvnw.cmd compile exec:java -Dexec.mainClass="com.flexisaf.paymentrecon.Main"  **I will find a better command for this soon, this is too complicated.
```
Or just use the Run button in VS Code (defaults to the `run` command).

## Run Tests
```
.\mvnw.cmd test
```

## Project Structure
| File | Purpose |
|---|---|
| `Main.java` | Entry point; wires all services together in sequence |
| `Invoice.java` | Data model — money owed by a payer |
| `PaymentRecord.java` | Data model — a payment recorded internally |
| `GatewayTransaction.java` | Data model — a payment reported by an external gateway/bank |
| `ChecksumCalculator.java` | Luhn algorithm — produces a check digit to catch typos |
| `ReferenceGeneratorService.java` | Builds a full reference (base + check digit) for an Invoice |
| `ReconciliationService.java` | Matches payments/gateway transactions against invoices; classifies MATCHED / MISMATCH / UNMATCHED |
| `InvoiceCsvStore.java` | Saves/loads Invoice data to/from CSV |
| `GatewayCsvImporter.java` | Imports gateway CSV, skipping corrupted rows |

This project was an interesting one and has pushed beyond my comfort zone.

Note: