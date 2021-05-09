package org.vs.others.recursion;

public class TowerOfHanoi {

    public static void move(int n, String from, String to, String inter) {

        if (n == 1) {
            System.out.println(String.format("moving disc %d from %s to %s", n, from, to));
        } else {
            move(n -1, from, inter, to);
            System.out.println(String.format("moving disc %d from %s to %s", n, from, to));
            move(n -1, inter, to, from);
        }
    }

    public static void main(String[] args) {
        move(4, "A", "B", "C");
    }
}
