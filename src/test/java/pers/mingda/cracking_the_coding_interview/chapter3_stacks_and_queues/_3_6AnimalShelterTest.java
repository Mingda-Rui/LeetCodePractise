package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _3_6AnimalShelterTest {

    @Test
    public void testAnimalShelter() {
        _3_6AnimalShelter animalShelter = new _3_6AnimalShelter();
        animalShelter.enqueue(new Dog(1));
        animalShelter.enqueue(new Cat(2));
        animalShelter.enqueue(new Dog(3));
        animalShelter.enqueue(new Dog(4));
        animalShelter.enqueue(new Cat(5));
        animalShelter.enqueue(new Cat(6));

        assertEquals(1, animalShelter.dequeueAny().number);
        assertEquals(2, animalShelter.dequeueAny().number);
        assertEquals(5, animalShelter.dequeueCat().number);
        assertEquals(6, animalShelter.dequeueCat().number);
        assertEquals(3, animalShelter.dequeueAny().number);
        assertEquals(4, animalShelter.dequeueDog().number);
    }

    @Test
    public void testAnimalShelterTwoStacks() {
        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(new Dog());
        aq.enqueue(new Cat());
        aq.enqueue(new Dog());
        aq.enqueue(new Dog());
        aq.enqueue(new Cat());
        aq.enqueue(new Cat());

        assertEquals(1, aq.dequeueAny().number);
        assertEquals(2, aq.dequeueAny().number);
        assertEquals(5, aq.dequeueCat().number);
        assertEquals(6, aq.dequeueCat().number);
        assertEquals(3, aq.dequeueAny().number);
        assertEquals(4, aq.dequeueDog().number);
    }
}
