import java.util.Objects;
import java.util.Scanner;

public class Task5 {
    private static final String[] departmentAddresses = {"HeroivUpa", "Vihovskoho", "Vuhilna", "Halytska", "Demnianska", "Stryiska", "Naukova"};
    private static final Shipment[] shipments = new Shipment[10];
    private static int shipmentsLastIndex = 0;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        createShipment();
        PrintShipments(shipments);
        removeShipment();
        PrintShipments(shipments);
    }

    private static void createShipment() {
        double maxWeight = 0, maxSize = 0;
        System.out.print("Enter delivery method( truck | train | bus | bicycle ): ");
        String deliveryMethod = scan.next();

        // Max weight and size depending on delivery method
        if(Objects.equals(deliveryMethod, "truck")) {
            maxWeight = 250;
            maxSize = 200;
        } else if (Objects.equals(deliveryMethod, "train")) {
            maxWeight = 150;
            maxSize = 150;
        } else if (Objects.equals(deliveryMethod, "bus")) {
            maxWeight = 100;
            maxSize = 100;
        } else if (Objects.equals(deliveryMethod, "bicycle")) {
            maxWeight = 40;
            maxSize = 50;
        } else {
            System.out.println("No such delivery method!");
            createShipment();
        }

        // Creating customer
        System.out.print("Enter customer name: ");
        String customerName = scan.next();
        System.out.print("Enter customer address: ");
        String customerAddress = scan.next();

        // Initializing receive and departure points
        System.out.print("Enter receive point: ");
        String receivePoint = scan.next();
        System.out.print("Enter departure point: ");
        String departurePoint = scan.next();

        // Checking if shipment points include departure point
        boolean contains = false;
        for (String address : departmentAddresses) {
            if (address.equals(departurePoint)) {
                contains = true;
                break;
            }
        }
        if(!contains) {
            deliveryMethod = "bicycle";
            maxWeight = 40;
            maxSize = 50;
        }

        // Adding item
        System.out.println("MAX WEIGHT OF ITEM: " + maxWeight + " | MAX SIZE OF ITEM: " + maxSize);
        System.out.print("Enter item name: ");
        String itemName = scan.next();
        System.out.print("Enter item weight: ");
        double itemWeight = scan.nextDouble();
        System.out.print("Enter item size: ");
        double itemSize = scan.nextDouble();
        if(itemWeight > maxWeight || itemSize > maxSize) {
            System.out.println("We are not able to deliver this item.");
            return;
        }

        Shipment s = Shipment.createShipment(
                (int) (Math.random() * 9000) + 1000,
                itemName,
                itemWeight,
                itemSize,
                maxWeight,
                maxSize,
                customerName,
                customerAddress,
                receivePoint,
                departurePoint,
                deliveryMethod
        );
        shipments[shipmentsLastIndex] = s;
        shipmentsLastIndex++;
    }

    private static void removeShipment() {
        System.out.print("Enter shipment id to delete: ");
        int shipmentId = scan.nextInt();
        for (int i = 0; i < shipmentsLastIndex; i++) {
            if (shipments[i] != null && shipments[i].getId() == shipmentId) {
                for (int j = i; j < shipmentsLastIndex - 1; j++) {
                    shipments[j] = shipments[j + 1];
                }
                shipments[shipmentsLastIndex - 1] = null;
                shipmentsLastIndex--;
                System.out.println("Shipment with ID " + shipmentId + " removed.");
                return;
            }
        }
    }

    private static void PrintShipments(Shipment[] shipments) {
        System.out.println();
        for (int i = 0; i < shipmentsLastIndex; i++) {
            System.out.println(shipments[i]);
            System.out.println();
        }
    }
}