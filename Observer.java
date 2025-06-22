public interface Observer {
    void update(float price);
}
public interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
import java.util.*;
public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }
}
public class MobileApp implements Observer {
    public void update(float price) {
        System.out.println("Mobile App Stock price " + price);
    }
}
public class WebApp implements Observer {
    public void update(float price) {
        System.out.println("Web App Stock price " + price);
    }
}
public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        market.registerObserver(mobile);
        market.registerObserver(web);
        market.setPrice(150.0f);
    }
}
