public class OnlinePaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Online Payment");
        return true;
    }
}
