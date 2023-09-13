package ThreadSignalling;

public class SpuriousWakeupGuard {

    // SPURIOUS WAKEUP MEANS A THREAD IN WAIT STATE GETS WAKED UP WITHOUT NOTIFY BEING CALLED
    // THIS IS MOSTLY A BUG IN THE JVM, BUT WE STILL NEED TO HANDLE IT

    boolean wasSignalled = false;

    Object monitorObject = new Object();

    public void doWait() throws InterruptedException {
        synchronized (monitorObject){

            while(!wasSignalled){
                this.wait();
                // IF THIS THREAD GETS A SPURIOUS WAKEUP, STILL IT CANT GET OUT OF THE WHILE LOOP
                // UNTIL IS SIGNALLED IS TRUE;
            }

            wasSignalled= false;
            // AFTER EXITING FROM WAIT STATE, WE NEED TO RETURN WASSIGNALLED TO DEFAULT STATE
        }
    }

    public void doNotify(){
        synchronized (this){
            wasSignalled=true;
            this.notify();
        }
    }
}
