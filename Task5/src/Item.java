public class Item {
    private final String name;
    private final double weight;
    private final double size;

    public Item(String name, double weight, double size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }
}