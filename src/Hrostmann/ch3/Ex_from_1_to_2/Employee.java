package Hrostmann.ch3.Ex_from_1_to_2;

public class Employee implements Measurable {

    private final String name;
    private final double salary;

    private Employee(String name,double salary) {
        this.name=name;
        this.salary=salary;
    }

    public static Employee hireEmployee(String name,double salary) {
        return new Employee(name,salary);
    }

    public double getMeasure(){
        return this.salary;
    }

    public String getName() {
        return name;
    }
}
