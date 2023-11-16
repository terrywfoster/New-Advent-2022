import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day01;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day01Test {
    @Test
    public void day1Part1() throws IOException, URISyntaxException {
        String dayOneTestInput = new String(Files.readAllBytes(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day01/TestInput.txt"))
                        .toURI())));
        String dayOnePuzzleInput = new String(Files.readAllBytes(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day01/PuzzleInput.txt"))
                        .toURI())));

        Assertions.assertThat(Day01.day1(dayOneTestInput, 1)).isEqualTo(24000);
        Assertions.assertThat(Day01.day1(dayOnePuzzleInput, 1)).isEqualTo(70698);
    }
    @Test
    public void day1Part2() throws IOException, URISyntaxException {
        String dayOneTestInput = new String(Files.readAllBytes(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day01/TestInput.txt"))
                        .toURI())));
        String dayOnePuzzleInput = new String(Files.readAllBytes(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day01/PuzzleInput.txt"))
                        .toURI())));

        Assertions.assertThat(Day01.day1(dayOneTestInput, 2)).isEqualTo(45000);
        Assertions.assertThat(Day01.day1(dayOnePuzzleInput, 2)).isEqualTo(206643);
    }

}
