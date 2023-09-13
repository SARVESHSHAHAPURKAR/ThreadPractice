package ThreadSignalling;

public class SignalCarrier {

    public void doWait() throws InterruptedException {

        synchronized (this) {
            System.out.println("Calling wait");
            this.wait();
            // WAIT METHOD CAN BE CALLED ON AN OBJECT ON WHICH SYNCHRONIZATION IS HAPPENING
            // CALLING WAIT METHOD WILL RELEAE THE SYNCHRONIZATION
            System.out.println("Exiting wait");

        }
    }

    public void doNotify(){

        synchronized (this){
            System.out.println("Calling notify");
            this.notify();
            // NOTIFY METHOD CAN BE CALLED ON AN OBJECT ON WHICH SYNCHRONIZATION IS HAPPENING
            // CALLING NOTIFY METHOD WILL RELEASE THE SYNCHRONIZATION BLOCK.. AND WILL CONTINUE THE
            // WAITING THREAD, THUS THE WAITING THREAD WILL TAKE UP THE SYNC ON MONITOR OBJECT.
            // HOWEVER, FOR THIS TO SUCCEED, WAIT() NAD NOTIFY() SHOULD BE SYNCHRNOIZED ON THE SAME
            // MONITOR OBJECT
            System.out.println("Exiting notify");
        }
    }

    public void doNotifyAll(){

        synchronized (this){
            System.out.println("Calling notify all");
            this.notifyAll();
            // NOTIFY METHOD CAN BE CALLED ON AN OBJECT ON WHICH SYNCHRONIZATION IS HAPPENING
            // CALLING NOTIFY METHOD WILL RELEASE THE SYNCHRONIZATION BLOCK.. AND WILL CONTINUE THE
            // WAITING THREAD, THUS THE WAITING THREAD WILL TAKE UP THE SYNC ON MONITOR OBJECT.
            // HOWEVER, FOR THIS TO SUCCEED, WAIT() NAD NOTIFY() SHOULD BE SYNCHRNOIZED ON THE SAME
            // MONITOR OBJECT
            System.out.println("Exiting notify all");
        }
    }
}
