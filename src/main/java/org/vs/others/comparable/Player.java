package org.vs.others.comparable;

import java.util.*;

public class Player implements Comparable {

    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Player other = (Player) o;
        return Integer.compare(score, other.score);
    }

    public static void main(String[] args) {
        List<Player> list = new ArrayList<>();
        Player player1 = new Player("Vishal", 20);
        Player player2 = new Player("Andy", 18);
        Player player3 = new Player("Amy", 19);
        Player player4 = new Player("Harry", 12);
        Player player5 = new Player("Nick", 14);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        list.add(player5);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

}

