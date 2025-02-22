package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_10LivingPeople {
    int maxAliveYear(LivingPerson[] people, int min, int max) {
        int count = 0;
        for (LivingPerson person : people) {
            if (person.birth >= min && person.birth <= max) {
                count++;
            }
        }
        return count;
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
