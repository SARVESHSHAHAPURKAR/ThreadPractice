package ThreadLocal;

public class ThreadLocalWithInitialValue {

    public static void main(String[] args) {


        ThreadLocal<Object> myThreadLocal1 = new ThreadLocal<Object>(){

            @Override
            protected Object initialValue() {
                return new Object();
            }
        };

        ThreadLocal<Object> myThreadLocal2 = ThreadLocal.withInitial(()->{
            return new Object();
        });

        Thread t1 = new Thread(() ->{
            Object obj1 = myThreadLocal1.get();
            Object obj2 = myThreadLocal2.get();

            System.out.println("Object 1 is "+obj1);
            System.out.println("Object 2 is "+obj2);
        });

        Thread t2 = new Thread(() ->{
            Object obj1 = myThreadLocal1.get();
            Object obj2 = myThreadLocal2.get();

            System.out.println("Object 1 is "+obj1);
            System.out.println("Object 2 is "+obj2);
        });

        t1.start();
        t2.start();

    }


}
