package com.lincoln.lab.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author geng.lin
 * 
 */
public class OOMofHeap {

    public class OOMObject {

    }

    private static List<OOMObject> list;

    /**
     * @param args
     */
    public static void main(String[] args) {

	list = new ArrayList<OOMofHeap.OOMObject>();
	while (true) {
	    list.add((new OOMofHeap()).new OOMObject());
	    System.out.println(list.size());
	}
    }
}
