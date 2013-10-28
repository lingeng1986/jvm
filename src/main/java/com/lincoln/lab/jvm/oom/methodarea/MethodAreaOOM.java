package com.lincoln.lab.jvm.oom.methodarea;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author geng.lin
 * 
 */
public class MethodAreaOOM {

    /**
     * @param args
     */
    public static void main(String[] args) {
	while (true) {
	    Enhancer enhancer = new Enhancer();
	    enhancer.setSuperclass(InnerOOMObject.class);
	    enhancer.setUseCache(false);
	    enhancer.setCallback(new Callback() {
		public Object intercept(Object o, Method m, Object[] args,
			MethodProxy p) {
		    try {
			return p.invokeSuper(o, args);
		    } catch (Throwable e) {
			return null;
		    }
		}

	    });
	    enhancer.create();
	}
    }

    static class InnerOOMObject {
    }

}
