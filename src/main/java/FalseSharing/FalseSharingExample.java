package FalseSharing;

public class FalseSharingExample {

    public static void main(String[] args) {

        Counter counter1 = new Counter();
        Counter counter2 = counter1;

        Thread t1 = new Thread(() -> {

            long startTime = System.currentTimeMillis();
            for(int i=0; i<200000000; i++){
                counter1.count1++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Total time taken by Thread 1 is : "+(endTime-startTime));
        });

        Thread t2 = new Thread(() -> {

            long startTime = System.currentTimeMillis();
            for(int i=0; i<200000000; i++){
                counter1.count2++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Total time taken by Thread 2 is : "+(endTime-startTime));
        });

        t1.start();
        t2.start();

    }
}
