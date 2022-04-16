package external;

import java.util.Collections;
import java.util.List;

public class MockPaymentSystem implements PaymentSystem {

    private List<Transactions> paymentRecord;
    public boolean processPayment(String buyerAccountEmail, String sellerAccountEmail, double transactionAmount) {
        Transactions newPayment = new Transactions(buyerAccountEmail, sellerAccountEmail, transactionAmount);
        this.paymentRecord.add(newPayment);
        return true;
    }

    public boolean processRefund(String buyerAccountEmail, String sellerAccountEmail, double transactionAmount) {
        Transactions refundingPayment = new Transactions(buyerAccountEmail, sellerAccountEmail, transactionAmount);
        for (Transactions payment : paymentRecord) {
            if (payment.equals(refundingPayment)) {
                paymentRecord.remove(payment);
                return true;
            }
        }
        System.out.println("This payment doesn't exist!");
        return false;
    }
}

class Transactions {

    private String buyerAccountEmail;
    private String sellerAccountEmail;
    private double transactionAmount;

    public Transactions(String buyerAccountEmail,
                        String sellerAccountEmail,
                        double transactionAmount){
        this.buyerAccountEmail = buyerAccountEmail;
        this.sellerAccountEmail = sellerAccountEmail;
        this.transactionAmount = transactionAmount;
    }

    public boolean equals(Transactions t){
        return (this.buyerAccountEmail.equals(t.getBuyerAccountEmail()) &&
                this.sellerAccountEmail.equals(t.getSellerAccountEmail()) &&
                this.transactionAmount == t.getTransactionAmount());
    }

    public String getBuyerAccountEmail() {
        return buyerAccountEmail;
    }

    public String getSellerAccountEmail() {
        return sellerAccountEmail;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}
