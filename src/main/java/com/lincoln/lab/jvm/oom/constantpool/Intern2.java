package com.lincoln.lab.jvm.oom.constantpool;

public class Intern2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String str1 = new StringBuilder("123").append("456").toString();

	System.out.println(str1.intern().equals(str1));
	System.out.println(str1.intern() == str1);

	String str2 = new StringBuilder("abc").append("efg").toString();
	System.out.println(str2.intern().equals(str2));
	System.out.println(str2.intern() == str2);

	String str3 = new StringBuilder("ja").append("va").toString();
	System.out.println(str3.intern().equals(str3));
	System.out.println(str3.intern() == str3);
    }
}
