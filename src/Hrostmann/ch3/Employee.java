package Hrostmann.ch3;

public class Employee implements Measurable {

    private String name;
    private double salary;

    Employee(String name,double salary) {
        this.name=name;
        this.salary=salary;
    }

    public double getMeasure(){
        return this.salary;
    }

    public String getName() {
        return name;
    }
}
