package model;

public enum BookingStatus {
    Active,
    CANCELLED_BY_CONSUMER,
    CANCELLED_BY_PROVIDER,
    PAYMENT_FAILED;

    /*public static BookingStatus[] values(){
        BookingStatus[] output = {Active, CANCELLED_BY_CONSUMER, CANCELLED_BY_PROVIDER, PAYMENT_FAILED};
        return output;
    }

    public static BookingStatus valueOf(String name){
        return switch (name) {
            case "Active" -> Active;
            case "CancelledByConsumer" -> CANCELLED_BY_CONSUMER;
            case "CancelledByProvider" -> CANCELLED_BY_PROVIDER;
            case "PaymentFailed" -> PAYMENT_FAILED;
            default -> null;
        };
    }
     */
}
