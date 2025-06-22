public interface Notifier {
    void send(String message);
}
public class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
public abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    public void send(String message) {
        notifier.send(message);
    }
}
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier decoratedNotifier = new SMSNotifierDecorator(notifier);
        decoratedNotifier.send("Your order has been shipped!");
    }
}