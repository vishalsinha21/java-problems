package org.vs.ctci.stackandqueue.shelter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalShelterTest {

    @Test
    void should_add_animals_to_queue() {
        AnimalShelter shelter = new AnimalShelter();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(cat2);
        shelter.enqueue(dog2);
        shelter.enqueue(dog3);

        assertThat(shelter.dequeueAny()).isEqualTo(dog1);
        assertThat(shelter.dequeueDog().get()).isEqualTo(dog2);
        assertThat(shelter.dequeueDog().get()).isEqualTo(dog3);

        assertThat(shelter.dequeueAny()).isEqualTo(cat1);
        assertThat(shelter.dequeueCat().get()).isEqualTo(cat2);
    }
}