public class Bottle {
    public int mL;
    public Beverage beverage;
    
    public Bottle(int mL, Beverage beverage) {
        this.mL = mL;
        this.beverage = beverage;
    }
    
    public Bottle(int mL, String flavor, String color) {
        this.mL = mL;
        this.beverage = new Beverage(flavor, color);
    }
}
