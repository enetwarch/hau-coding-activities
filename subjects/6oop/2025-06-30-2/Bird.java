public class Bird {
    public String breed;
    public boolean isNocturnal;
    
    public Bird() {
        this.breed = "Unknown";
        this.isNocturnal = false;
    }
    
    public Bird(String breed, boolean isNocturnal) {
        this.breed = breed;
        this.isNocturnal = isNocturnal;
    }
}
