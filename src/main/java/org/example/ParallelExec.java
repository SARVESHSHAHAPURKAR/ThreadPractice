package org.example;


    class HiNew extends Thread{

        public void run(){
            for(int i=0; i<5; i++){
                System.out.println("HiNew");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    class HelloNew extends Thread{

        public void run(){
            for(int i=0; i<5; i++){
                System.out.println("HelloNew");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public class ParallelExec {

        public static void main (String args[]) throws InterruptedException {
            HiNew obj1 = new HiNew();
            HelloNew obj2 = new HelloNew();

            obj1.start();
            Thread.sleep(100);
            obj2.start();
            // PARALLEL EXECUTION( ASYNC).. BUT THIS WILL PRINT RANDOMLY, ORDER NOT MAINTAINED
            // WE NEED ONE HI.. ONE HELLO.. AND SO NON.. SO ADD A SLEEP() between these 2
        }
    }

