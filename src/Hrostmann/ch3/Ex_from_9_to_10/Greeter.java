package Hrostmann.ch3.Ex_from_9_to_10;

public class Greeter implements Runnable {
    private final int count;
    private final String person;

    private Greeter (String person, int count) {
        this.count=count;
        this.person=person;
    }

    static public Greeter greetMe(String person,int count) {
        if(!person.isEmpty() && count>0)
            return new Greeter(person, count);
        else
            return new Greeter("Incognito",1);
    }
    public void run() {
        for(int i=0;i<count;i++)
            System.out.println("Hello, "+person);
    }
}
