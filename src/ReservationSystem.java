import java.util.ArrayList;

public class ReservationSystem {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event findEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equals(name)) return event;
        }
        return null;
    }

    public Customer findCustomerByLastName(String lastName) {
        for (Customer customer : customers) {
            if (customer.getLastName().equals(lastName)) return customer;
        }
        return null;
    }

    public void changeEventPrice(String eventName, double newPrice) {
        Event event = findEventByName(eventName);
        if (event != null) {
            event.changePrice(newPrice);
        }
    }

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        Event concert = new Event("Symphony Concert", 120.0);
        Event theater = new Event("Theater Play", "2025-04-10", "City Hall", 85.0);
        system.addEvent(concert);
        system.addEvent(theater);

        Customer customer1 = new Customer("Alice", "Smith", "alice@email.com");
        Customer customer2 = new Customer("John", "Doe", "john@email.com");
        system.addCustomer(customer1);
        system.addCustomer(customer2);

        customer1.addReservation(concert);
        customer1.addReservation(theater);
        customer2.addReservation(concert);

        System.out.println("Customer1 reservations:\n" + customer1.getReservationStatus());
        System.out.println("Customer2 reservations:\n" + customer2.getReservationStatus());

        customer1.removeReservation("Theater Play");
        System.out.println("After cancellation, Customer1 reservations:\n" + customer1.getReservationStatus());

        system.changeEventPrice("Symphony Concert", 150.0);
        System.out.println("New concert price: " + concert.getPrice());
        System.out.println("Available seats for concert: " + concert.getAvailableSeats());
    }
}