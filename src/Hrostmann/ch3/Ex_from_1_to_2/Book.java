package Hrostmann.ch3.Ex_from_1_to_2;

/**
 * Realize book entity
 * @author Konstantin
 * @version 1.0
 */
public class Book implements Measurable {
    private String name;
    private int pages;

    /**
     * Standart constructor
     * @param name book title
     * @param pages number of book pages
     */
    private Book(String name,int pages) {
        this.name=name;
        this.pages=pages;
    }

    /**
     * Fabric method
     * @param name book title
     * @param pages number of book pages
     * @return new Book exemple
     */
    public static Book writeBook(String name,int pages) {
        return new Book(name,pages);
    }

    /**
     * Access method for pages
     * @return number of pages in this exemplar
     */
    public double getMeasure()
    {
        return this.pages;
    }
    /**
     * Access method for name
     * @return title of this book exemplar
     */
    public String getName() {
        return this.name;
    }
}
