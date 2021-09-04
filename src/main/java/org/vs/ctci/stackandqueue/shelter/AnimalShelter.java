package org.vs.ctci.stackandqueue.shelter;

import java.util.LinkedList;
import java.util.Optional;

public class AnimalShelter {
    private LinkedList<Animal> list;

    public AnimalShelter() {
        list = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        list.add(animal);
    }

    public Animal dequeueAny() {
        return list.remove();
    }

    public Optional<Animal> dequeueDog() {
        for (Animal animal : list) {
            if (animal.type() == AnimalType.DOG) {
                list.remove(animal);
                return Optional.ofNullable(animal);
            }
        }
        return Optional.empty();
    }

    public Optional<Animal> dequeueCat() {
        for (Animal animal : list) {
            if (animal.type() == AnimalType.CAT) {
                list.remove(animal);
                return Optional.ofNullable(animal);
            }
        }
        return Optional.empty();
    }
}

interface Animal {
    AnimalType type();
}

class Dog implements Animal {
    @Override
    public AnimalType type() {
        return AnimalType.DOG;
    }
}

class Cat implements Animal {
    @Override
    public AnimalType type() {
        return AnimalType.CAT;
    }
}

enum AnimalType {
    CAT, DOG
}