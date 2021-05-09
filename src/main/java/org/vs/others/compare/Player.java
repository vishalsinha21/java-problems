package org.vs.others.compare;

import java.util.Arrays;
import java.util.Comparator;

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

    public static void main(String[] args) {
        Player[] players = new Player[5];
        players[0] = new Player("Vishal", 20);
        players[1] = new Player("Andy", 18);
        players[2] = new Player("Amy", 19);
        players[3] = new Player("Harry", 12);
        players[4] = new Player("Nick", 14);

        Arrays.sort(players, new Checker());
        System.out.println(Arrays.toString(players));
    }

}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        if (Integer.compare(player2.score, player1.score) == 0) {
            return player1.name.compareTo(player2.name);
        } else {
            return Integer.compare(player2.score, player1.score);
        }
    }

}