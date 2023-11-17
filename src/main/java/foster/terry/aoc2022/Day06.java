package foster.terry.aoc2022;

import java.util.Collections;
import java.util.stream.Collectors;

public class Day06 {
    final private String buffer;
    public Day06(final String input)
    {
        this.buffer = input;
    }

    public int findFirstMarker(final int markerLength)
    {
        for (int x = 0; x < buffer.length()-markerLength; x++) {
            if (uniqueCharacters(buffer.substring(x,x+markerLength))) {
                return x + markerLength;
            }
        }
        return -1;
    }
    boolean uniqueCharacters(String s)
    {
        return s.chars().filter(e -> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1).count() <= 1;
    }
}
