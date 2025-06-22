public interface CustomerRepository {
    String findCustomerById(String id);
}
public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer: " + id + " - John Doe";
    }
}
public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void getCustomer(String id) {
        System.out.println(repository.findCustomerById(id));
    }
}
public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.getCustomer("123");
    }
}