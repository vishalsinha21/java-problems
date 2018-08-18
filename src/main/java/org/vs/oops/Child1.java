package org.vs.oops;

public class Child1 extends Parent {

    public static String className = "Child1";

    static {
        System.out.println("Child1 static block");
        method1();
    }

}
