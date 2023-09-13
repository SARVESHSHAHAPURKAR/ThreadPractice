package org.example;

class Hi{

    public void show(){
        for(int i=0; i<5; i++){
            System.out.println("Hi");
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }

}

class Hello{

    public void show(){
        for(int i=0; i<5; i++){
            System.out.println("Hello");
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }

}

public class Sleep {

    public static void main (String args[]) {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        obj1.show();
        obj2.show();
        // SERIAL EXECUTION( IN SYNC)
    }
}
