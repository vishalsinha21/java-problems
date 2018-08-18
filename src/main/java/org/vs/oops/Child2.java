package org.vs.oops;

public class Child2 extends Parent {

    public static String className = "Child2";

    static {
        System.out.println("Child2 static block");
        method1();
    }

    public static void method1() {
        System.out.println("child2 method1");
    }

}
