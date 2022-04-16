package external;

import java.util.Collections;
import java.util.List;

public class MockPaymentSystem implements PaymentSystem {

    private List<Transactions> paymentRecord;

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
