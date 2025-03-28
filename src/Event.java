public class Event {
    private String name;
    private String date;
    private String location;
    private int maxNumberOfGuests = 100;
    private int availableSeats = 100;
    private double price;

    public Event(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Event(String name, double price, int availableSeats) {
        this.name = name;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public Event(String name, String date, String location, double price) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public int getAvailableSeats() { return availableSeats; }

    public void reserveSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void cancelReservation() {
        if (availableSeats < maxNumberOfGuests) {
            availableSeats++;
        }
    }

    public void changePrice(double newPrice) {
        this.price = newPrice;
    }
}
