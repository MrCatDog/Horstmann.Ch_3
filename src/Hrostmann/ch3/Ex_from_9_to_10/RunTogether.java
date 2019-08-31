package Hrostmann.ch3.Ex_from_9_to_10;

import java.util.ArrayList;
import java.util.Arrays;

public class RunTogether implements Runnable {
    private ArrayList<Runnable> tasks = new ArrayList<>();

    public void run() {
        for(Runnable i : this.tasks)
            new Thread(i).start();
    }

    public RunTogether(Runnable... tasks) {
        this.tasks.addAll(Arrays.asList(tasks));
    }
}
