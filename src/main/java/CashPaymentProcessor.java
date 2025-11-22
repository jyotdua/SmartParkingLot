public class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing Cash Payment");
        return true;
    }
}
