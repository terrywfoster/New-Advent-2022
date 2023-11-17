package foster.terry.aoc2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 {
    private final List<int[]> assignments = new ArrayList<>();
    public Day04(final List<String> input) {
        for(final String assignment : input) {
            assignments.add(Arrays.stream(assignment.split("[-,]")).mapToInt(Integer::parseInt).toArray());
        }
    }

    public int fullyContained()
    {
        int fullyContainedCount = 0;
        for(final int[] ass : assignments) {

            if(
                    (ass[0] >= ass[2] && ass[1] <= ass[3])
                    ||
                    (ass[2] >= ass[0] && ass[3] <= ass[1])
            ) {
                fullyContainedCount++;
            }


        }
        return fullyContainedCount;

    }
    public int overlaps()
    {
        int overlapsCount = 0;
        for(final int[] ass : assignments) {
            if(ass[0] <= ass[3] && ass[2] <= ass[1]) {
                overlapsCount++;
            }
        }

        return overlapsCount;
    }
}
