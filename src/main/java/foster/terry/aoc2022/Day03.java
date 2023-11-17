package foster.terry.aoc2022;

import java.util.HashSet;
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

    public int priorityTotal()
    {
        int priorityTotal = 0;
        for(String rucksack : rucksacks)
        {
            Set<Character> compartment1 = rucksack.substring(0,rucksack.length()/2)
                    .chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            Set<Character> compartment2 = rucksack.substring(rucksack.length()/2)
                    .chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            compartment1.retainAll(compartment2);

            for(char item : compartment1) {
                priorityTotal += priority.indexOf(item) + 1;
            }

        }
        return priorityTotal;
    }

    public int badgeTotal(final int groupSize)
    {
        int currGroupSize = 0, badgeTotal = 0;
        Set<Character> prevRuckSackItems = new HashSet<>();
        for(String rucksack : rucksacks) {
            currGroupSize++;
            Set<Character> rucksackItems = rucksack.chars().mapToObj(e->(char)e).collect(Collectors.toSet());

            if (!prevRuckSackItems.isEmpty())
                rucksackItems.retainAll(prevRuckSackItems);

            if (currGroupSize == groupSize) {
                for(char item : rucksackItems) {
                    badgeTotal += priority.indexOf(item) + 1;
                }

                currGroupSize = 0;
                prevRuckSackItems = new HashSet<>();
                continue;
            }
            prevRuckSackItems = rucksackItems;

        }
        return badgeTotal;
    }
}
