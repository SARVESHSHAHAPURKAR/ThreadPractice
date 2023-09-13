package ThreadSignalling;

public class ThreadSignalingPractice {

    public static void main(String[] args) {

        SignalCarrier signalCarrier = new SignalCarrier();

        Thread waiter = new Thread(() ->{
            try {
                signalCarrier.doWait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread notifier = new Thread(()->{
            signalCarrier.doNotify();
        });

        waiter.start();
        notifier.start();

        // NOTE THAT WE CANT CONTROL THE ORDER OF WAIT AND NOTIFY IN THIS PARTICULAR IMPLEMENTATION
        // , THUS NOTIFY CAN GET CALLED BEFORE WAIT
        // LEADING TO MISSED SIGNALS.. WE HAVE HANDLED THIS IN SIGNAL CARRIER CLASS.
    }
}
