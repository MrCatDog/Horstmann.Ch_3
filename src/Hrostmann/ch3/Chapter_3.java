package Hrostmann.ch3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Chapter_3 {
    public static void main(String[] args) {
        Measurable[] govno = new Measurable[3];
        govno[0] = new Employee("Fred",55.6);
        govno[1] = new Employee("John",100);
        govno[2] = new Employee("Emy",110);
        System.out.println(average(govno));
        Employee large = (Employee) largest(govno);
        System.out.println(large.getName());

        govno[0] = new Book("Fred's journey",400);
        govno[1] = new Book("John's textbook",234);
        govno[2] = new Book("Emy's journey",347);
        System.out.println(average(govno));
        Book large2 = (Book) largest(govno);
        System.out.println(large2.getName());

        IntSequence seq = IntSequence.of(1,1,1,12,3,4,5);
        while (seq.hasNext())
            System.out.println(seq.next());

        System.out.println();

        seq = IntSequence.of2(1,2,3,4,5,6,7);
        for(int i=0;i<10;i++)
            System.out.println(seq.next());

        seq = IntSequence.constant(73);
        for(int i=0;i<10;i++)
            System.out.println(seq.next());

        Sequence seq2 = new SquareSequence();
        for(int i=0;i<3;i++)
            System.out.println(seq2.next().toString());

        seq2 = new DoubleSquareSequence();
        for(int i=0;i<3;i++)
            System.out.println(seq2.next());

    }

    static private double average(Measurable[] objects) {
        double sum=0;
        for(Measurable i:objects)
            sum+=i.getMeasure();
        return sum/objects.length;
    }

    static private Measurable largest(Measurable[] objects) {
        int largest=0;
        for(int i=1;i<objects.length;i++)
            if(objects[i].getMeasure()>objects[largest].getMeasure())
                largest=i;
        return objects[largest];
    }

}
