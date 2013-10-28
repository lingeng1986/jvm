package com.lincoln.lab.jvm.oom.directmemory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class DirectMemoryOOM {

    private static final long _1MB = 1024 * 1024;

    /**
     * @param args
     */
    public static void main(String[] args) {
	Field unsafeField = Unsafe.class.getDeclaredFields()[0];
	unsafeField.setAccessible(true);
	Unsafe unsafe = null;
	try {
	    unsafe = (Unsafe) unsafeField.get(null);
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	while (true) {
	    unsafe.allocateMemory(_1MB);
	}
    }

}
