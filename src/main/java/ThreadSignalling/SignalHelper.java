package ThreadSignalling;

public class SignalHelper {

    int signalsRaised=0;
    int threadsWaiting=0;

    public void doWait() throws InterruptedException {
        synchronized (this) {

            if(signalsRaised>0){
                signalsRaised--;
                return;
            }
            System.out.println("Calling wait");
            threadsWaiting++;
            this.wait();
            threadsWaiting--;
            System.out.println("Exiting wait");

        }
    }

    public void doNotify(){
        synchronized (this){

            if(threadsWaiting==0){
                signalsRaised++;
            }

            System.out.println("Entering notify");
            this.notify();
            System.out.println("Exiting notify");


        }
    }
}
