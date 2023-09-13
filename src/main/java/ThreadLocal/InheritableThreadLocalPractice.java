package ThreadLocal;

public class InheritableThreadLocalPractice {

    // INHERITABLE THREAD LOCAL IS A THREAD LOCAL WHICH CAN BE ACCESSED BY A THREAD AS WELL AS
    // ITS CHILD THREAD.

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

        Thread t1 = new Thread(() -> {

            System.out.println("===========Thread 1=========");

            threadLocal.set("String 1");
            inheritableThreadLocal.set("Inherited String 1");

            System.out.println("The local value by "+Thread.currentThread().getName()+
                    " is "+threadLocal.get());
            System.out.println("The inherited local value by "+Thread.currentThread().getName()+
                    " is "+inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {

                System.out.println("===========Child Thread 1=========");

                //threadLocal.set("String 1");
                //inheritableThreadLocal.set("Inherited String 1");

                System.out.println("The local value by "+Thread.currentThread().getName()+
                        " is "+threadLocal.get());
                System.out.println("The inherited local value by "+Thread.currentThread().getName()+
                        " is "+inheritableThreadLocal.get());

            },"Child Thread");
        },
                "Thread 1"

        );

        Thread t2 = new Thread(() -> {

            System.out.println("===========Thread 2=========");

            //threadLocal.set("String 2");
            //inheritableThreadLocal.set("Inherited String 1");

            System.out.println("The local value by "+Thread.currentThread().getName()+
                    " is "+threadLocal.get());
            System.out.println("The inherited local value by "+Thread.currentThread().getName()+
                    " is "+inheritableThreadLocal.get());


        },
                "Thread 2"

        );

        t1.start();
        t2.start();


    }
}
