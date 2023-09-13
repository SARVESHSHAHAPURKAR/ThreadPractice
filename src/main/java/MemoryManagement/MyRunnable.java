package MemoryManagement;

public class MyRunnable implements Runnable{

    Object globalObject = new Object();
    // AS THIS IS AN INSTANCE VARIABLE, ITS REFERENCE WILL NOT BE SAVED IN THE THREAD STACK, AND IT
    // WILL RETURN THE SAME REFERENCE WHEN SAME INSTANCE OF RUNNABLE IS USED.


    @Override
    public void run() {

        Object myObject = new Object();
        // AS THIS OBJECT IS A LOCAL VARIABLE, EACH THREAD WILL HAVE A REFERENCE TO IT, IN THEIR OWN STACK
        // EVEN IF YOU USE THE SAME INSTANCE OF RUNNABLE IN DIFFERNET THREADS, THESE MYOBJECT WILL RETURN
        // DIFFERENT REFERENCES

        System.out.println("Local object is : "+myObject);
        System.out.println("Global object is : "+globalObject);
    }
}
