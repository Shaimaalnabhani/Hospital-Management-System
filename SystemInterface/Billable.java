package SystemInterface;

public interface Billable {

    double calculateCharges();
    String generateBill();
    boolean processPayment(double amount);

}
