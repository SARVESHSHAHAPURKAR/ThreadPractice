package ThreadLocal;

public class ThreadLocalPractice {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        // A THREADLOCAL IS A DATA STRUCTURE WHERE EACH THREAD CAN SAVE ITS VARIABLE AND ONLY THAT THREAD
        // CAN GET/SET IT , OTHER THREADS CANNOT TOUCH IT... IT IS LIKE A LOCKER ROOM OF THREADS

        Thread t1 = new Thread(() -> {
            threadLocal.set("String 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            threadLocal.remove();
            // REMOVES THE VALUE FOR THIS THREAD, FROM THE THREADLOCAL

            System.out.println("Variable value is "+threadLocal.get()+ " for "+Thread.currentThread().getName());
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            threadLocal.set("String 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Variable value is "+threadLocal.get()+ " for "+Thread.currentThread().getName());
        }, "Thread 2");

        t1.start();
        t2.start();
    }
}
