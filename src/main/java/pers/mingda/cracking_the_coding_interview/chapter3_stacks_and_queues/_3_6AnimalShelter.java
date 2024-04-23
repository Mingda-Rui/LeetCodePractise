package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first
 *  out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 *  or they can select whether they would prefer a dog or cat (and will receive the oldest animal of
 *  that type). They cannot select which specific animal they would like. Create the data structures to
 *  maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 *  and dequeueCat. You may use the built-in LinkedList data structure.
 */

public class _3_6AnimalShelter {

    private Queue<Animal> animalQueue;
    private Queue<Dog> dogQueue;
    private Queue<Cat> catQueue;

    public _3_6AnimalShelter() {
        animalQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dogQueue.offer(dog);

        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            catQueue.offer(cat);
        } else {
            throw new IllegalArgumentException("Unknown type of animal");
        }
        animalQueue.offer(animal);
    }

    public Animal dequeueAny() {
        Animal animal = animalQueue.poll();
        while (animal.isAdopted) {
            animal = animalQueue.poll();
        }
        if (animal instanceof Dog) {
            dogQueue.poll();
        } else if (animal instanceof Cat) {
            catQueue.poll();
        }
        return animal;
    }

    public Dog dequeueDog() {
        Dog dog = dogQueue.poll();
        dog.isAdopted = true;
        return dog;
    }

    public Cat dequeueCat() {
        Cat cat = catQueue.poll();
        cat.isAdopted = true;
        return cat;
    }
}

class AnimalQueue {
    Queue<Dog> dogQueue;
    Queue<Cat> catQueue;
    int counter;

    public AnimalQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        counter++;
        animal.number = counter;
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dogQueue.offer(dog);
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            catQueue.offer(cat);
        } else {
            throw new IllegalArgumentException("Unknown type of animal");
        }
    }

    public Dog dequeueDog() {
        return dogQueue.poll();
    }

    public Cat dequeueCat() {
        return catQueue.poll();
    }

    public Animal dequeueAny() {
        if (dogQueue.isEmpty())
            return catQueue.poll();
        else if (catQueue.isEmpty())
            return dogQueue.poll();

        boolean pollDogQueue = dogQueue.peek().number < catQueue.peek().number;
        return pollDogQueue ? dogQueue.poll() : catQueue.poll();
    }
}

abstract class Animal {
    boolean isAdopted;
    int number;
}

class Cat extends Animal {
    public Cat() {}

    public Cat(int number) {
        this.number = number;
    }
}

class Dog extends Animal {
    public Dog() {}

    public Dog(int number) {
        this.number = number;
    }
}
