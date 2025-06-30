public class Music {
    public int duration;
    public String genre;
    
    public Music() {
        this.duration = 0;
        this.genre = "Unknown";
    }
    
    public Music(int duration, String genre) {
        this.duration = duration;
        this.genre = genre;
    }
    
    public Music(int duration, String genre, char durationType) {
        this.duration = calculateDuration(duration, durationType);
        this.genre = genre;
    }
    
    private static int calculateDuration(int duration, char durationType) {
        return switch(durationType) {
            case 'm' -> duration;
            case 'h' -> duration * 60;
            case 'd' -> duration * 60 * 24;
            default -> duration;
        };
    }
}
