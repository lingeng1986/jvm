package com.lincoln.lab.jvm.sof;

/**
 * 
 * -Xms2m -Xmx2m -Xss10m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * 这样设置，为什么不会报OOM，而还是SOF？
 * 
 * @author geng.lin
 * 
 */
public class SofWithMultiThreads {

    /**
     * @param args
     */
    public static void main(String[] args) {
	SofWithMultiThreads sof = new SofWithMultiThreads();
	sof.stackLeakByThread();

    }

    private void stackLeakByThread() {
	while (true) {
	    new Thread(new Runnable() {

		public void run() {
		    StackIncreaser increaser = new StackIncreaser();
		    try {
			increaser.stackIncrease();
		    } catch (Throwable e) {
			System.out.println(e.getClass().getName());
		    }
		}
	    }).start();
	}
    }

    class StackIncreaser {
	int index;

	long forMemory = Long.MAX_VALUE;

	void stackIncrease() {
	    index++;
	    stackIncrease();
	}
    }

}
