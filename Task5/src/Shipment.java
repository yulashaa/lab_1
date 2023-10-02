import java.util.Arrays;

public class Shipment {
    private final int id;
    private final Item item;
    private final double maxWeight;
    private final double maxSize;
    private final Customer customer;
    private final ReceivePoint receivePoint;
    private final DeparturePoint departurePoint;
    private final String deliveryMethod;

    public Shipment(int id, Item item, double maxWeight, double maxSize, Customer customer, ReceivePoint receivePoint, DeparturePoint departurePoint, String deliveryMethod) {
        this.id = id;
        this.item = item;
        this.maxWeight = maxWeight;
        this.maxSize = maxSize;
        this.customer = customer;
        this.receivePoint = receivePoint;
        this.departurePoint = departurePoint;
        this.deliveryMethod = deliveryMethod;
    }

    public int getId() {
        return id;
    }

    public static Shipment createShipment(int id, String itemName, double itemWeight, double itemSize, double maxWeight, double maxSize, String customerName, String customerAddress, String receivePointAddress, String departurePointAddress, String deliveryMethod) {
        Customer customer = new Customer(customerName, customerAddress);
        Item item = new Item(itemName, itemWeight, itemSize);
        ReceivePoint receivePoint = new ReceivePoint(receivePointAddress);
        DeparturePoint departurePoint = new DeparturePoint(departurePointAddress);

        return new Shipment(id, item, maxWeight, maxSize, customer, receivePoint, departurePoint, deliveryMethod);
    }

    @Override
    public String toString() {
        return "Shipment id: " + id + "\n" +
                "Item: " + item.getName() + " | Item weight: " + item.getWeight() + " | Item size: " + item.getSize() + "\n" +
                "Max weight: " + maxWeight + " | Max size: " + maxSize + "\n" +
                "Customer name: " + customer.getName() + " | Customer address: " + customer.getAddress() + "\n" +
                receivePoint.getAddress() + " -> " + departurePoint.getAddress() + "\n" +
                "Delivery method: " + deliveryMethod;
    }
}