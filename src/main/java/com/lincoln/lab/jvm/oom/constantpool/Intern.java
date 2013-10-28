package com.lincoln.lab.jvm.oom.constantpool;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=5M -XX:MaxPermSize=5M
 * 
 * this program will run well in jre7, but out of memory of constants pool in
 * jre6 and before.
 * 
 * @author geng.lin
 * 
 */
public class Intern {

    /**
     * @param args
     */
    public static void main(String[] args) {
	List<String> interns = new ArrayList<String>();

	int index = 0;
	while (true) {
	    index++;
	    interns.add(String.valueOf(index).intern());
	    System.out.println(index);
	}

    }

}
