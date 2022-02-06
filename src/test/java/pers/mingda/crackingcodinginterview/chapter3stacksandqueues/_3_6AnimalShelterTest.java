package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _3_6AnimalShelterTest {

    _3_6AnimalShelter animalShelter;

    @BeforeEach
    public void setup() {
        animalShelter = new _3_6AnimalShelter();
    }

    @Test
    public void testAnimalShelter() {
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
}
