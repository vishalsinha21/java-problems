package org.vs.others.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {

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

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        approach3();
    }

    private static void approach1() {
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

        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o1.score, o2.score);
            }
        });
        System.out.println(list);
    }

    private static void approach2() {
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

        Collections.sort(list, (o1, o2) -> Integer.compare(o1.score, o2.score));
        System.out.println(list);
    }

    private static void approach3() {
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

        Collections.sort(list, Comparator.comparingInt(Player::getScore));
        System.out.println(list);
    }
}

