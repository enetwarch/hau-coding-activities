public class Dog {
    private String breed;
    private int barkCount;
    
    public String getBreed() {
        return this.breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public int getBarkCount() {
        return this.barkCount;
    }
    
    public boolean hasBarkedALot() {
        return this.barkCount >= 100;
    }
    
    public void bark(int n) {
        this.barkCount += n;
        
        for (int i = 0; i < n; i++) {
            System.out.printf("Woof\n");
        }
    }
}
