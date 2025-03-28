public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private Event[] reservations;
    private int reservationCount = 0;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservations = new Event[5];
    }

    public Customer(String firstName, String lastName, String email) {
        this(firstName, lastName);
        this.email = email;
    }

    public void addReservation(Event event) {
        if (reservationCount < reservations.length) {
            reservations[reservationCount++] = event;
            event.reserveSeat();
        }
    }

    public void removeReservation(String eventName) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i] != null && reservations[i].getName().equals(eventName)) {
                reservations[i].cancelReservation();
                for (int j = i; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[--reservationCount] = null;
                break;
            }
        }
    }

    public String getReservationStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reservationCount; i++) {
            sb.append(reservations[i].getName()).append("\n");
        }
        return sb.toString();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public Event[] getReservations() { return reservations; }
}
