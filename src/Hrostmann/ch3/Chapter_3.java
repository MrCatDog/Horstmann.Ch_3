package Hrostmann.ch3;

import Hrostmann.ch3.Ex_from_1_to_2.*;
import Hrostmann.ch3.Ex_from_4_to_6.*;

public class Chapter_3 {
    public static void main(String[] args) {
        Measurable[] measurables = new Measurable[3];
        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Fred",55.6);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("John",100);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Emy",110);
        System.out.println(average(measurables));
        Employee large = (Employee) largest(measurables);
        System.out.println(large.getName());

        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Fred's journey",400);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("John's textbook",234);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Emy's journey",347);
        System.out.println(average(measurables));
        Book large2 = (Book) largest(measurables);
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
