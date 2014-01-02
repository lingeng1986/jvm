package com.lincoln.lab.jvm.gc;

/**
 * -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
 * 
 * @author geng.lin
 * 
 */
public class TestIfReferenceGC {

    private final static int _1MB = 1024 * 1024;

    public Object instance = null;

    private byte[] bytes = new byte[_1MB];

    /**
     * @param args
     */
    public static void main(String[] args) {
	TestIfReferenceGC a = new TestIfReferenceGC();
	TestIfReferenceGC b = new TestIfReferenceGC();

	a.instance = b;
	b.instance = a;
	a = null;
	b = null;

	System.gc();
    }

}
