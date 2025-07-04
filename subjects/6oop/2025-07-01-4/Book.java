public class Book {
    private String title;
    private int numberOfPages;
    private boolean isFictional;
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }
    
    public void setNumberOfPages(int pages) {
        this.numberOfPages = pages;
    }

    public boolean getIsFictional() {
        return this.isFictional;
    }

    public void setIsFictional(boolean isFictional) {
        this.isFictional = isFictional;
    }
}
