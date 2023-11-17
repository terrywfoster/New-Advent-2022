package foster.terry.aoc2022;

import java.util.*;

public class Day01 {
    private final List<Integer> calorieTotals = new ArrayList<>();

    public Day01(final List<String> input)
    {
        int currentCalories = 0;
        Iterator<String> iterator = input.iterator();

        while (iterator.hasNext())
        {
            final String line = iterator.next();

            if (!line.isBlank())
                currentCalories += Integer.parseInt(line);

            if (line.isBlank() || !iterator.hasNext()) {

                calorieTotals.add(currentCalories);

                currentCalories = 0;
            }
        }
    }

    public int totalTopCalories(int limit) {
        return calorieTotals.stream().sorted(Comparator.reverseOrder()).mapToInt(v -> v).limit(limit).sum();
    }
}
