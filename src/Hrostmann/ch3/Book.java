package Hrostmann.ch3;

public class Book implements Measurable {
    private String name;
    private int pages;

    Book(String name,int pages) {
        this.name=name;
        this.pages=pages;
    }

    public double getMeasure()
    {
        return this.pages;
    }

    public String getName() {
        return this.name;
    }
}
