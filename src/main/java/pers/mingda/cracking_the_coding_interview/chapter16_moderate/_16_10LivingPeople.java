package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.Comparator;

public class _16_10LivingPeople {
    int maxAliveYear(LivingPerson[] people, int min, int max) {
        LivingPerson[] sortedByBirth = getSorted(people, Comparator.comparingInt(a -> a.birth));
        LivingPerson[] sortedByDeath = getSorted(people, Comparator.comparingInt(a -> a.death));

        int birthIndex = 0;
        int deathIndex = 0;

        int currentLives = 0;
        int maxLiveYear = 0;
        int maxLives = 0;

        for (int year = min; year <= max; year++) {
            while (birthIndex < sortedByBirth.length && year >= sortedByBirth[birthIndex].birth) {
                birthIndex++;
                currentLives++;
            }
            if (currentLives > maxLives) {
                maxLives = currentLives;
                maxLiveYear = year;
            }

            while(deathIndex < sortedByDeath.length && year > sortedByDeath[deathIndex].death) {
                deathIndex++;
                currentLives--;
            }
        }

        return maxLiveYear;
    }

    LivingPerson[] getSorted(LivingPerson[] people, Comparator<LivingPerson> comparator) {
        LivingPerson[] copiedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(copiedPeople, comparator);
        return copiedPeople;
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
