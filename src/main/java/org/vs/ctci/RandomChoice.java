package org.vs.ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomChoice {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("name1", "name2", "name3");
        chooseRandom(list, 2);
    }

    public static void chooseRandom(List<String> names, int numberOfChoices) {
        Random random = new Random();
        int size = names.size();

        List<String> choices = new ArrayList<>();

        for (int i = 0; i < numberOfChoices; i++) {
            choices.add(names.get(random.nextInt(size)));
        }
    }

}
