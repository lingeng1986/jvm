package com.lincoln.lab.jvm.sof;

/**
 * -Xss128k
 * 
 * @author geng.lin
 * 
 */
public class Sof1 {

    static int index;

    public static void main(String[] args) {

	try {
	    add();
	} catch (Throwable e) {
	    System.out.println("index=" + index);
	    System.out.println(e.getClass().getName());
	}
    }

    private static void add() {
	index++;
	add();
    }

}
