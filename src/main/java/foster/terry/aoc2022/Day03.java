package foster.terry.aoc2022;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Day03 {
    private final List<String> rucksacks;
    private final String priority;

    public Day03(final List<String> input)
    {
        this.rucksacks = input;

        this.priority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public int priorityTotal() {
        int priorityTotal = 0;
        for(String rucksack : rucksacks)
        {
            final Set<Character> compartment1 = characterSet(rucksack.substring(0,rucksack.length()/2));
            final Set<Character> compartment2 = characterSet(rucksack.substring(rucksack.length()/2));

            compartment1.retainAll(compartment2);

            for(char item : compartment1) {
                priorityTotal += priority.indexOf(item) + 1;
            }

        }
        return priorityTotal;
    }

    public int badgeTotal(final int groupSize) {

        int badgeTotal = 0;
        for(int x = 0; x < rucksacks.size(); x += groupSize)
        {
            final Set<Character> firstRucksackItems = characterSet(rucksacks.get(x));
            for(int y = 0; y < groupSize-1; y++)
            {
                final Set<Character> nextRucksackItems = characterSet(rucksacks.get(x + y + 1));
                firstRucksackItems.retainAll(nextRucksackItems);
            }

            for(char item : firstRucksackItems) {
                badgeTotal += priority.indexOf(item) + 1;
            }
            System.out.println();
        }
        return badgeTotal;


    }

    private Set<Character> characterSet(final String items) {

        return items.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
    }
}
