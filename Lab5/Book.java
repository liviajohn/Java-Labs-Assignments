class Book extends Item {
    private String isbnNumber;
    private String author;

    public Book() {
        super();
        this.isbnNumber = "";
        this.author = "";
    }

    public Book(String title, String isbnNumber, String author) {
        super(title);
        this.isbnNumber = isbnNumber;
        this.author = author;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getListing() {
        return "Book Name - " + getTitle() + "\nAuthor - " + author + "\nISBN # - " + isbnNumber;
    }
}