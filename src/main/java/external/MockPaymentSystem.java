package external;

public class MockPaymentSystem implements PaymentSystem {

    public MockPaymentSystem(){}

    public boolean processPayment(String buyerAccountEmail,
                                   String sellerAccountEmail,
                                   double transactionAmount){}

    public boolean processRefund(String buyerAccountEmail,
                                  String sellerAccountEmail,
                                  double transactionAmount){}

}
