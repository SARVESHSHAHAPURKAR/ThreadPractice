package FalseSharing;

import sun.misc.Contended;

public class Counter {

    @Contended
    public volatile int count1 = 0;

    public volatile int count2 = 0;
}
