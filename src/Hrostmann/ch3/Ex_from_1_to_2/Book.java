package Hrostmann.ch3.Ex_from_1_to_2;

public class Book implements Measurable {
    private String name;
    private int pages;

    private Book(String name,int pages) {
        this.name=name;
        this.pages=pages;
    }

    public static Book writeBook(String name,int pages) {
        return new Book(name,pages);
    }

    public double getMeasure()
    {
        return this.pages;
    }

    public String getName() {
        return this.name;
    }
}
