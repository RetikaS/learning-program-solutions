public interface Image {
    void display();
}
public class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }
    private void loadFromServer() {
        System.out.println("Loading " + filename);
    }
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("pic.jpg");
        image.display(); 
        image.display();
    }
}