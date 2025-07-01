public class Car {
    private String color;
    private double price;
    private char size;
    
    public Car(String color, double price, char size) {
        this.color = color;
        this.price = price;
        this.size = size;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public char getSize() {
        return this.size;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setSize(char size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return String.format("Car (%s) - P%.2f - %s", this.color, this.price, Car.stringifySize(this.size));
    }
    
    private static String stringifySize(char size) {
        return switch (Character.toUpperCase(size)) {
            case 'S' -> "small";
            case 'M' -> "medium";
            case 'L' -> "large";
            default -> "unknown";
        };
    }
}
