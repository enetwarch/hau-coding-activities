public class Money {
    public int amount;
    public String denomination;
    
    public Money() {
        this.amount = 0;
        this.denomination = "Unknown";
    }
    
    public Money(int amount) {
        this.amount = amount;
        this.denomination = "Unknown";
    }
    
    public Money(int amount, String denomination) {
        this.amount = amount;
        this.denomination = denomination;
    }
}
