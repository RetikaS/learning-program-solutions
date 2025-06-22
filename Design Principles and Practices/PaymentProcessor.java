public interface PaymentProcessor {
    void processPayment(double amount);
}
public class OldPaymentGateway {
    public void makePayment(double value) {
        System.out.println("Paid " + value + " using Old Gateway");
    }
}
public class PaymentAdapter implements PaymentProcessor {
    private OldPaymentGateway gateway;
    public PaymentAdapter(OldPaymentGateway gateway) {
        this.gateway = gateway;
    }
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        OldPaymentGateway oldGateway = new OldPaymentGateway();
        PaymentProcessor processor = new PaymentAdapter(oldGateway);
        processor.processPayment(100.0);
    }
}
