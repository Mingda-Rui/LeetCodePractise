package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.Comparator;

public class _16_10LivingPeople {
    int maxAliveYear(LivingPerson[] people, int min, int max) {
        LivingPerson[] sortedByBirth = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedByBirth, Comparator.comparingInt(a -> a.birth));

        LivingPerson[] sortedByDeath = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedByDeath, Comparator.comparingInt(a -> a.death));

        int birthIndex = 0;
        int deathIndex = 0;

        int currentLives = 0;
        int maxLives = 0;

        for (int year = min; year <= max; year++) {
            while (birthIndex < sortedByBirth.length && year >= sortedByBirth[birthIndex].birth) {
                birthIndex++;
                currentLives++;
            }
            maxLives = Math.max(maxLives, currentLives);
            while(deathIndex < sortedByDeath.length && year > sortedByDeath[deathIndex].death) {
                deathIndex++;
                currentLives--;
            }
        }

        return maxLives;
    }
}

class LivingPerson {
    public int birth;
    public int death;
    public LivingPerson(int birthYear, int deathYear) {
        birth = birthYear;
        death = deathYear;
    }
}
