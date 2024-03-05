abstract class Item {
    private String title;

    public Item() {
        this.title = "";
    }

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String getListing();

    @Override
    public String toString() {
        return "Title: " + title;
    }
}