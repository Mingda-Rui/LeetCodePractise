package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.Comparator;

public class _16_10LivingPeople {

  int maxAliveYear(LivingPerson[] people, int min, int max) {
    LivingPerson[] sortedByBirth = getSorted(
      people,
      Comparator.comparingInt(a -> a.birth)
    );
    LivingPerson[] sortedByDeath = getSorted(
      people,
      Comparator.comparingInt(a -> a.death)
    );

    int birthIndex = 0;
    int deathIndex = 0;

    int currentLives = 0;
    int maxLiveYear = 0;
    int maxLives = 0;

    while (birthIndex < sortedByBirth.length) {
      if (sortedByBirth[birthIndex].birth <= sortedByDeath[deathIndex].death) {
        birthIndex++;
        currentLives++;
        if (currentLives > maxLives) {
          maxLives = currentLives;
          maxLiveYear = sortedByBirth[birthIndex].birth;
        }
      } else {
        deathIndex++;
        currentLives--;
      }
    }

    return maxLiveYear;
  }

  LivingPerson[] getSorted(
    LivingPerson[] people,
    Comparator<LivingPerson> comparator
  ) {
    LivingPerson[] copiedPeople = Arrays.copyOf(people, people.length);
    Arrays.sort(copiedPeople, comparator);
    return copiedPeople;
  }

  int maxAliveYearOptimized(LivingPerson[] people, int min, int max) {
    int[] delta = getPopulationDeltas(people, min, max);
    return getMaxLiveYear(delta) + min;
  }

  int[] getPopulationDeltas(LivingPerson[] people, int min, int max) {
    int[] delta = new int[max - min + 2];
    for (LivingPerson p : people) {
      delta[p.birth - min]++;
      delta[p.death - min + 1]--;
    }
    return delta;
  }

  int getMaxLiveYear(int[] delta) {
    int maxLiveYear = 0;
    int currentLives = 0;
    int maxLives = 0;

    for (int year = 0; year < delta.length; year++) {
      currentLives += delta[year];
      if (currentLives > maxLives) {
        maxLives = currentLives;
        maxLiveYear = year;
      }
    }

    return maxLiveYear;
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
