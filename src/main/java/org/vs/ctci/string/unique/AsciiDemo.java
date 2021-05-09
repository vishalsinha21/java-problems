package org.vs.ctci.string.unique;

public class AsciiDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 256; i++) {
            char ch = (char) i;

            System.out.println(i + "::" + ch);
        }
    }
}
