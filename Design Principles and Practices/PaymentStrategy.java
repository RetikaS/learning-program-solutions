public interface PaymentStrategy {
    void pay(double amount);
}
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
public class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}
public class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.executePayment(250.0);
        context.setStrategy(new PayPalPayment());
        context.executePayment(150.0);
    }
}
