package foster.terry.aoc2022;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day01 {
    public static int day1(String input, int whichPart) {

        PriorityQueue<Integer> topCalories = new PriorityQueue<>(3);

        int maxCalories = 0, currentCalories = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // process the line
            if (line != null && !line.trim().isEmpty())
            {
                currentCalories += Integer.parseInt(line);
            }
            if (line == null || line.trim().isEmpty() || !scanner.hasNextLine())
            {
                if (maxCalories < currentCalories ) {
                    maxCalories = currentCalories;
                }
                topCalories.add(currentCalories);
                if (topCalories.size() > 3)
                    topCalories.poll();

                currentCalories = 0;
            }
        }
        scanner.close();

        Integer[] arrCalories = topCalories.toArray(new Integer[0]);
        int totalTopCalories = Arrays.stream(arrCalories)
                .mapToInt(Integer::intValue)
                .sum();
        if (whichPart == 1)
        {
            return maxCalories;
        }
        return totalTopCalories;
    }

}
