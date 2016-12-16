package Procrastination;

public class TestPlan {
    public static void main(String[] args) {
        MyTask[] assignments = new MyTask[] { new MyTask(9,1), new MyTask(9,2), new MyTask(7,1)   };

        int startTime = Plan.procrastination(assignments);
        System.out.println(startTime);

        assignments = new MyTask[] { new MyTask(3,2), new MyTask(3,2)   };
        startTime = Plan.procrastination(assignments);
        System.out.println(startTime);

    }
}
