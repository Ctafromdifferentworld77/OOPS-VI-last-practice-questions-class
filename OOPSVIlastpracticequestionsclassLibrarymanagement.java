import java.time.LocalDate;
import java.util.*;

abstract class Item {
    String id, title;
    LocalDate date;
    int days;

    Item(String id, String title, LocalDate date, int days) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.days = days;
    }
}

class Book extends Item {
    Book(String id, String title, LocalDate date) {
        super(id, title, date, 21);
    }
}

class CD extends Item {
    CD(String id, String title, LocalDate date) {
        super(id, title, date, 14);
    }
}

class DVD extends Item {
    DVD(String id, String title, LocalDate date) {
        super(id, title, date, 7);
    }
}

class Patron {
    String name;
    int id;
    List<Item> items = new ArrayList<>();

    Patron(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void checkOut(Item item) {
        if (items.size() < 10) items.add(item);
    }

    void returnItem(Item item) { items.remove(item); }
    int getCount() { return items.size(); }
}

public class Main {
    public static void main(String[] args) {
        Book a = new Book("B001", "1984", LocalDate.of(1949, 6, 8));
        CD c = new CD("C001", "Thriller", LocalDate.of(1982, 11, 30));
        DVD d = new DVD("D001", "Inception", LocalDate.of(2010, 7, 16));

        Patron alice = new Patron("Alice", 1234);
        alice.checkOut(a);
        alice.checkOut(c);

        System.out.println("Checked-out items: " + alice.getCount()); // 2

        alice.returnItem(c);
        System.out.println("Items after return: " + alice.getCount()); // 1
    }
}