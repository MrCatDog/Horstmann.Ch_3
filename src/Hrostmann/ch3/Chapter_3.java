package Hrostmann.ch3;

import Hrostmann.ch3.Ex_8.*;
import Hrostmann.ch3.Ex_from_1_to_2.*;
import Hrostmann.ch3.Ex_from_4_to_6.*;
import Hrostmann.ch3.Ex_from_9_to_10.*;

import java.util.ArrayList;

/**
 *Base class to check all classes one by one
 * @author Konstantin
 * @version 1.0
 */
public class Chapter_3 {
    public static void main(String[] args) {
        ex1_2();
        ex4_5();
        ex6();
        ex8();
        ex9_10();
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

    static private void ex1_2() {
        //Ex.1
        Measurable[] measurables = new Measurable[3];
        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Fred",55.6);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("John",100);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Emy",110);
        System.out.println(average(measurables));
        Employee large = (Employee) largest(measurables);
        System.out.println(large.getName());

        //Ex.2
        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Fred's journey",400);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("John's textbook",234);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Emy's journey",347);
        System.out.println(average(measurables));
        Book large2 = (Book) largest(measurables);
        System.out.println(large2.getName());
    }

    static private void ex4_5() {
        //Ex.4
        IntSequence seq = IntSequence.of(1, 1, 1, 12, 3, 4, 5);
        while (seq.hasNext())
            System.out.println(seq.next());

        System.out.println();

        seq = IntSequence.of2(1, 2, 3, 4, 5, 6, 7);
        for (int i = 0; i < 10; i++)
            System.out.println(seq.next());

        //Ex.5
        seq = IntSequence.constant(73);
        for (int i = 0; i < 10; i++)
            System.out.println(seq.next());
    }

    static private void ex6() {
        //Ex.6
        Sequence seq2 = new SquareSequence();
        for (int i = 0; i < 3; i++)
            System.out.println(seq2.next().toString());

        seq2 = new DoubleSquareSequence();
        for (int i = 0; i < 3; i++)
            System.out.println(seq2.next());
    }

    static private void ex8() {
        //Ex.8
        ArrayList<String> list = new ArrayList<>();
        list.add("once");
        list.add("told");
        list.add("me");
        list.add("Somebody");

        java.util.Comparator<String> comp = new LengthComparator();
        ArrayListSort.luckySort(list, comp);
        System.out.println(list);

        java.util.Comparator<Integer> comp2 = new LengthComparatorForInt();
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(68);
        list2.add(1);
        list2.add(145);
        ArrayListSort.luckySort(list2, comp2);
        System.out.println(list2);
    }

    static private void ex9_10() {
        Greeter first = Greeter.greetMe("First",7);
        Greeter second = Greeter.greetMe("Second",5);
        Runnable together = new RunTogether(first,second);
        Runnable inOrder = new RunInOrder(first,second);
        new Thread(new RunInOrder(together,inOrder)).start();
    }
}
